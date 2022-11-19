package GUI.Controllers;

import BUSINESS.CurrentUser;
import BUSINESS.exceptions.NegativeNumberException;
import BUSINESS.validators.Quantity;
import LOGGING.ErrorLogging;
import BUSINESS.create.InsertInvoice;
import BUSINESS.exceptions.CustomException;
import BUSINESS.repository.GoodRepository;
import BUSINESS.repository.PartnerRepository;
import GUI.AlertBox;
import LOGGING.ExceptionToString;
import ORM.Good;
import ORM.Partner;
import ORM.Transactions;
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
        //Set one of the radio buttons as selected
        purchaseRadio.setSelected(true);

        //List of all goods
        listGood.setCellValueFactory(new PropertyValueFactory<>("good"));
        listPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        listQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        goodsList.setItems(getGoods());

        //List of picked goods
        addedGoods = FXCollections.observableArrayList();
        addedGood.setCellValueFactory(new PropertyValueFactory<>("good"));
        addedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        addedQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        setPartners();

        totalPrice = 0;
    }

    public void addButtonClicked() {
        try {
            Good good = goodsList.getSelectionModel().getSelectedItem();

            //Create new good
            Good newListGood = new Good();
            newListGood.setId(good.getId());
            newListGood.setGood(good.getGood());
            newListGood.setPrice(good.getPrice());
            newListGood.setMinQuantity(good.getMinQuantity());
            newListGood.setQuantity(Integer.parseInt(quantityField.getText()));

            addedGoods.add(newListGood);
            addedGoodsList.setItems(addedGoods);

            totalPrice += newListGood.getPrice() * newListGood.getQuantity();
            totalPriceLabel.setText("Тотална цена: " + totalPrice + "лв.");

            quantityField.setText("");
        } catch (NumberFormatException e) {
            AlertBox.display("Грешни данни", "Въведете количество за избраната стока!");
        }
    }

    public void createButtonClicked() {
        try {
            //Date
            LocalDate invoiceDate = dateField.getValue();

            //User id
            int userId = CurrentUser.getInstance().getUserId();

            //Transaction Type
            Transactions transactionName;
            if (saleRadio.isSelected())
                transactionName = Transactions.SALE;
            else
                transactionName = Transactions.PURCHASE;

            //Partner
            Partner partner = partnerField.getSelectionModel().getSelectedItem();
            if(partner == null)
                throw new CustomException("Изберете партньор!");

            //Goods
            List<Good> goods = addedGoodsList.getItems();

            InsertInvoice.create(invoiceDate, goods, userId, partner.getId(), transactionName);
            AlertBox.display("Съобщение", "Успешно Създаване!");
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
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

    public void removeFromList() {
        Good good = addedGoodsList.getSelectionModel().getSelectedItem();

        addedGoods.remove(good);
        addedGoodsList.setItems(addedGoods);

        totalPrice -= good.getPrice() * good.getQuantity();
        totalPriceLabel.setText("Тотална цена: " + totalPrice + "лв.");
    }
}
