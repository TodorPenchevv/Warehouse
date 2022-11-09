package GUI.Controllers;

import BUSINESS.repository.InvoiceRepository;
import GUI.CustomRow;
import GUI.DateConverter;
import ORM.Invoice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.*;

public class ListInvoices {
    @FXML private DatePicker start;
    @FXML private DatePicker end;

    @FXML private TableView<CustomRow> table;
    @FXML private TableColumn<CustomRow, Calendar> date;
    @FXML private TableColumn<CustomRow, String> transaction;
    @FXML private TableColumn<CustomRow, String> partnerName;
    @FXML private TableColumn<CustomRow, String> userName;

    public void submitButtonClicked(){
        LocalDate date1 = start.getValue();
        Calendar calendar1 = new GregorianCalendar(date1.getYear(), date1.getMonthValue()-1, date1.getDayOfMonth());
        LocalDate date2 = end.getValue();
        Calendar calendar2 = new GregorianCalendar(date2.getYear(), date2.getMonthValue()-1, date2.getDayOfMonth());

        ObservableList<CustomRow> list  = FXCollections.observableArrayList();

        List<Invoice> invoices = new InvoiceRepository().findByPeriod(calendar1, calendar2);
        String rowTransaction, rowPartnerName, rowUserName, rowDate;


        for (Invoice invoice : invoices){
            rowTransaction = invoice.getTransaction().getTransaction().toString();
            rowPartnerName = invoice.getPartner().getName();
            rowUserName = invoice.getUser().getName();
            rowDate = DateConverter.convert(invoice.getCalendar());


            CustomRow row = new CustomRow.Builder()
                    .withTransaction(rowTransaction)
                    .withPartnerName(rowPartnerName)
                    .withUserName(rowUserName)
                    .withDate(rowDate).build();
            list.add(row);
        }

        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        transaction.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        partnerName.setCellValueFactory(new PropertyValueFactory<>("partnerName"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));


        table.setItems(list);
    }


}
