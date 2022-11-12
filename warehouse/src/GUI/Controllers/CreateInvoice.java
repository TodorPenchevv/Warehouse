package GUI.Controllers;

import BUSINESS.create.InsertInvoice;
import BUSINESS.repository.GoodRepository;
import BUSINESS.repository.PartnerRepository;
import ORM.Good;
import ORM.Partner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class CreateInvoice implements Initializable {
    @FXML private TableView<Good> goodsList;
    @FXML private TableColumn<Good, String> listGood;
    @FXML private TableColumn<Good, Double> listPrice;
    @FXML private TableColumn<Good, Integer> listQuantity;

    @FXML private TableView<Good> addedGoodsList;
    @FXML private TableColumn<Good, String> addedGood;
    @FXML private TableColumn<Good, Double> addedPrice;
    @FXML private TableColumn<Good, Integer> addedQuantity;

    @FXML private TextField quantityField;
    @FXML private DatePicker dateField;
    @FXML private ComboBox<Partner> partnerField;

    @FXML private RadioButton saleRadio;
    @FXML private RadioButton purchaseRadio;

    @FXML private Label totalPriceLabel;
    @FXML private Label successLabel;

    private ObservableList<Good> addedGoods;
    private double totalPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //List of all goods
        listGood.setCellValueFactory(new PropertyValueFactory<>("good"));
        listPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        listQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        goodsList.setItems(getGoods());

        //List of picked goods
        addedGoods  = FXCollections.observableArrayList();
        addedGood.setCellValueFactory(new PropertyValueFactory<>("good"));
        addedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        addedQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        setPartners();

        totalPrice = 0;
    }

    public void addButtonClicked(){
        Good good = goodsList.getSelectionModel().getSelectedItem();
        good.setQuantity(Integer.parseInt(quantityField.getText()));
        addedGoods.add(good);
        addedGoodsList.setItems(addedGoods);
        //shouldn't be able to add the same good more than once
        //shouldn't be able to add more quantity than is available
        totalPrice += good.getPrice()*good.getQuantity();
        totalPriceLabel.setText("Тотална цена: "+totalPrice+"лв.");
        quantityField.setText("");
    }

    public void createButtonClicked() {
        //Date
        LocalDate date1 = dateField.getValue();
        Calendar invoiceDate = new GregorianCalendar(date1.getYear(), date1.getMonthValue()-1, date1.getDayOfMonth());

        //User id = 1 because we dont have current user at the moment

        //Transaction Type
        int transactionID;
        if (saleRadio.isSelected()) //one radio must be selected
            transactionID = 1;
        else
            transactionID = 2;

        //Partner
        Partner partner = partnerField.getSelectionModel().getSelectedItem();

        //Goods
        List<Good> goods = addedGoodsList.getItems();

        InsertInvoice.create(invoiceDate, goods, 1, partner.getId(), transactionID);
        successLabel.setText("Успешно Създаване!");
    }

    public ObservableList<Good> getGoods() {
        List<Good> goods = GoodRepository.findAll();
        ObservableList<Good> list = FXCollections.observableArrayList();
        list.addAll(goods);
        return list;
    }

    public void setPartners(){
        List<Partner> partners = PartnerRepository.findAll();
        ObservableList<Partner> list = FXCollections.observableArrayList();
        list.addAll(partners);
        partnerField.setItems(list);
    }
}
