package GUI.Controllers;

import BUSINESS.repository.InvoiceRepository;
import GUI.CustomRow;
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
    @FXML private TableColumn<CustomRow, String> type;
    @FXML private TableColumn<CustomRow, String> partner;
    @FXML private TableColumn<CustomRow, String> user;

    public void submitButtonClicked(){
        LocalDate date1 = start.getValue();
        Calendar calendar1 = new GregorianCalendar(date1.getYear(), date1.getMonthValue()-1, date1.getDayOfMonth());
        LocalDate date2 = end.getValue();
        Calendar calendar2 = new GregorianCalendar(date2.getYear(), date2.getMonthValue()-1, date2.getDayOfMonth());

        ObservableList<CustomRow> list  = FXCollections.observableArrayList();

        List<Invoice> invoices = new InvoiceRepository().findByPeriod(calendar1, calendar2);
        String rowType, rowPartner, rowUser, rowCalendar;


        for (Invoice invoice : invoices){
            rowType = invoice.getTransaction().getTransaction().toString();
            rowPartner = invoice.getPartner().getName();
            rowUser = invoice.getUser().getName();

            rowCalendar = invoice.getCalendar().getTime().toString();


            CustomRow row = new CustomRow(rowCalendar, rowType, rowPartner, rowUser);
            list.add(row);
        }

        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        partner.setCellValueFactory(new PropertyValueFactory<>("partner"));
        user.setCellValueFactory(new PropertyValueFactory<>("employee"));


        table.setItems(list);
    }


}
