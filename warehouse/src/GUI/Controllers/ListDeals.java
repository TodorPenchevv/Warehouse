package GUI.Controllers;

import BUSINESS.repository.InvoiceRepository;
import BUSINESS.tools.CustomRow;
import BUSINESS.tools.DateConverter;
import ORM.Invoice;
import ORM.Invoice_Good;
import ORM.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ListDeals {

    @FXML private DatePicker start;
    @FXML private DatePicker end;
    @FXML private RadioButton salesRadio;

    @FXML private TableView<CustomRow> table;
    @FXML private TableColumn<CustomRow, String> dateColumn;
    @FXML private TableColumn<CustomRow, String> userColumn;
    @FXML private TableColumn<CustomRow, String> partnerColumn;
    @FXML private TableColumn<CustomRow, Double> priceColumn;
    @FXML private TableColumn<CustomRow, String> detailColumn;

    @FXML
    void submitButtonClicked() {
        ObservableList<CustomRow> list = FXCollections.observableArrayList();

        LocalDate date1 = start.getValue();
        Calendar startDate = new GregorianCalendar(date1.getYear(), date1.getMonthValue() - 1, date1.getDayOfMonth());
        LocalDate date2 = end.getValue();
        Calendar endDate = new GregorianCalendar(date2.getYear(), date2.getMonthValue() - 1, date2.getDayOfMonth());


        String rowDate, rowUserName, rowPartnerName, rowDetails;
        double rowTotalPrice = 0;

        int transactionID;
        if (salesRadio.isSelected()) //one radio must be selected
            transactionID = 1;
        else
            transactionID = 2;

        List<Invoice> invoices = InvoiceRepository.findByPeriod(startDate, endDate);
        for (Invoice invoice : invoices) {
            if (invoice.getTransaction().getId()==transactionID) {
                rowDate = DateConverter.convert(invoice.getCalendar());
                rowUserName = invoice.getUser().getName();
                rowPartnerName = invoice.getPartner().getName();
                rowDetails = CustomRow.processDetails(invoice.getInvoice_goods());

                for (Invoice_Good ig : invoice.getInvoice_goods()) {
                    rowTotalPrice += ig.getPrice() * ig.getQuantity();
                }

                CustomRow row = new CustomRow.Builder()
                        .withDate(rowDate)
                        .withUserName(rowUserName)
                        .withPartnerName(rowPartnerName)
                        .withDetails(rowDetails)
                        .withTotalPrice(rowTotalPrice).build();
                list.add(row);
                rowTotalPrice = 0;
                System.out.println(invoice.getId() + " ");
            }
        }
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        partnerColumn.setCellValueFactory(new PropertyValueFactory<>("partnerName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        detailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));

        table.setItems(list);
    }

}

