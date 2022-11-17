package GUI.Controllers;

import BUSINESS.exceptions.CustomException;
import BUSINESS.repository.InvoiceRepository;
import GUI.AlertBox;
import LOGGING.ErrorLogging;
import ORM.Invoice;
import ORM.Invoice_Good;
import ORM.Transactions;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FinancialInfo {
    private static final Marker financialInfoMarker = MarkerManager.getMarker("financialInfo");
    @FXML private DatePicker start;
    @FXML private DatePicker end;

    @FXML private Label proceedLabel;
    @FXML private Label expenseLabel;
    @FXML private Label profitLabel;


    public void submitButtonClicked(){
        try {
            LocalDate startDate = start.getValue();
            LocalDate endDate = end.getValue();

            List<Invoice> invoices = InvoiceRepository.findByPeriod(startDate, endDate);
            loadFinancialInfo(invoices);
        } catch(CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch(Exception e) {
            new ErrorLogging().log(financialInfoMarker, e.getMessage());
        }
    }

    public void loadFinancialInfo(List<Invoice> invoices) {
        double undefined = 0, expenses = 0, proceeds = 0, profit = 0;

        for (Invoice invoice : invoices) {
            for (Invoice_Good invoice_good : invoice.getInvoice_goods()) {
                undefined += invoice_good.getQuantity() * invoice_good.getPrice();
            }
            if (invoice.getTransaction().getTransaction().equals(Transactions.PURCHASE))
                expenses += undefined;
            else
                proceeds += undefined;
            undefined = 0;
        }

        profit = proceeds - expenses;

        proceedLabel.setText("Приходи: " + String.valueOf(proceeds));
        expenseLabel.setText("Разходи: " + String.valueOf(expenses));
        profitLabel.setText("Печалба: " + String.valueOf(profit));
    }
}
