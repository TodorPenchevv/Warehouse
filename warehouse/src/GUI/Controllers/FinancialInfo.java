package GUI.Controllers;

import BUSINESS.repository.InvoiceRepository;
import ORM.Invoice;
import ORM.Invoice_Good;
import ORM.Transactions;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FinancialInfo {
    @FXML private DatePicker start;
    @FXML private DatePicker end;

    @FXML private Label proceedLabel;
    @FXML private Label expenseLabel;
    @FXML private Label profitLabel;


    public void submitButtonClicked(){
        LocalDate date1 = start.getValue();
        Calendar startDate = new GregorianCalendar(date1.getYear(), date1.getMonthValue()-1, date1.getDayOfMonth());
        LocalDate date2 = end.getValue();
        Calendar endDate = new GregorianCalendar(date2.getYear(), date2.getMonthValue()-1, date2.getDayOfMonth());

        double undefined = 0, expenses = 0, proceeds = 0, profit = 0;

        List<Invoice> invoices = InvoiceRepository.findByPeriod(startDate, endDate);

        for (Invoice invoice : invoices){
            for (Invoice_Good invoice_good : invoice.getInvoice_goods()){
                undefined += invoice_good.getQuantity()*invoice_good.getPrice();
            }
            if (invoice.getTransaction().getTransaction().equals(Transactions.PURCHASE))
                expenses += undefined;
            else
                proceeds += undefined;
            undefined = 0;
        }

        profit = proceeds - expenses;

        proceedLabel.setText("Приходи: "+String.valueOf(proceeds));
        expenseLabel.setText("Разходи: "+String.valueOf(expenses));
        profitLabel.setText("Печалба: "+String.valueOf(profit));
    }
}
