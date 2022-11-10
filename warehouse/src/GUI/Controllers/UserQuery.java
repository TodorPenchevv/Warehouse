package GUI.Controllers;

import BUSINESS.repository.GoodRepository;
import BUSINESS.repository.InvoiceRepository;
import BUSINESS.repository.PartnerRepository;
import BUSINESS.repository.UserRepository;
import BUSINESS.tools.CustomRow;
import BUSINESS.tools.DateConverter;
import ORM.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class UserQuery implements Initializable {

    @FXML private ComboBox<User> userField;
    @FXML private DatePicker start;
    @FXML private DatePicker end;

    @FXML private TableView<CustomRow> table;
    @FXML private TableColumn<CustomRow, String> dateColumn;
    @FXML private TableColumn<CustomRow, String> transactionColumn;
    @FXML private TableColumn<CustomRow, String> partnerColumn;
    @FXML private TableColumn<CustomRow, Double> priceColumn;
    @FXML private TableColumn<CustomRow, String> detailColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<User> users = UserRepository.findAll();
        ObservableList<User> list = FXCollections.observableArrayList();
        list.addAll(users);
        userField.setItems(list);
    }

    public void submitButtonClicked() {
        ObservableList<CustomRow> list = FXCollections.observableArrayList();

        User user = userField.getSelectionModel().getSelectedItem();

        LocalDate date1 = start.getValue();
        Calendar startDate = new GregorianCalendar(date1.getYear(), date1.getMonthValue() - 1, date1.getDayOfMonth());
        LocalDate date2 = end.getValue();
        Calendar endDate = new GregorianCalendar(date2.getYear(), date2.getMonthValue() - 1, date2.getDayOfMonth());


        String rowDate, rowTransaction, rowPartnerName, rowDetails;
        double rowTotalPrice = 0;


        List<Invoice> invoices = InvoiceRepository.findByPeriod(startDate, endDate);
        for (Invoice invoice : invoices) {
            if (invoice.getUser().getId()==user.getId()) {
                rowDate = DateConverter.convert(invoice.getCalendar());
                rowTransaction = invoice.getTransaction().getTransaction().toString();
                rowPartnerName = invoice.getPartner().getName();
                rowDetails = CustomRow.processDetails(invoice.getInvoice_goods());

                for (Invoice_Good ig : invoice.getInvoice_goods()) {
                    rowTotalPrice += ig.getPrice() * ig.getQuantity();
                }

                CustomRow row = new CustomRow.Builder()
                        .withDate(rowDate)
                        .withTransaction(rowTransaction)
                        .withPartnerName(rowPartnerName)
                        .withDetails(rowDetails)
                        .withTotalPrice(rowTotalPrice).build();
                list.add(row);
                rowTotalPrice = 0;
                System.out.println(invoice.getId() + " ");
            }
        }
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        partnerColumn.setCellValueFactory(new PropertyValueFactory<>("partnerName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));

        table.setItems(list);
    }
}
