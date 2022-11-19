package GUI.Controllers;

import BUSINESS.exceptions.CustomException;
import BUSINESS.repository.InvoiceRepository;
import BUSINESS.tools.CustomRow;
import BUSINESS.tools.DateConverter;
import GUI.AlertBox;
import LOGGING.ErrorLogging;
import LOGGING.ExceptionToString;
import ORM.Invoice;
import ORM.Invoice_Good;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.*;

public class ListTransactions {
    @FXML private DatePicker start;
    @FXML private DatePicker end;

    @FXML private TableView<CustomRow> table;
    @FXML private TableColumn<CustomRow, Calendar> dateColumn;
    @FXML private TableColumn<CustomRow, String> transactionColumn;
    @FXML private TableColumn<CustomRow, String> partnerColumn;
    @FXML private TableColumn<CustomRow, String> userColumn;
    @FXML private TableColumn<CustomRow, String> priceColumn;

    public void submitButtonClicked(){
        try {
            LocalDate startDate = start.getValue();
            LocalDate endDate = end.getValue();

            List<Invoice> invoices = InvoiceRepository.findByPeriod(startDate, endDate);
            loadDataIntoTable(invoices);
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }

    public void loadDataIntoTable(List<Invoice> invoices) {
        ObservableList<CustomRow> list  = FXCollections.observableArrayList();
        String rowTransaction, rowPartnerName, rowUserName, rowDate;
        double rowTotalPrice = 0;

        for (Invoice invoice : invoices){
            rowTransaction = invoice.getTransaction().getTransaction().toString();
            rowPartnerName = invoice.getPartner().getName();
            rowUserName = invoice.getUser().getName();
            rowDate = DateConverter.convert(invoice.getCalendar());

            for (Invoice_Good ig : invoice.getInvoice_goods()) {
                rowTotalPrice += ig.getPrice() * ig.getQuantity();
            }

            CustomRow row = new CustomRow.Builder()
                    .withTransaction(rowTransaction)
                    .withPartnerName(rowPartnerName)
                    .withUserName(rowUserName)
                    .withDate(rowDate)
                    .withTotalPrice(rowTotalPrice).build();
            list.add(row);
            rowTotalPrice=0;
        }

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        partnerColumn.setCellValueFactory(new PropertyValueFactory<>("partnerName"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        table.setItems(list);
    }
}
