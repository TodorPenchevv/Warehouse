package BUSINESS.repository;

import ORM.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Lister {
    //Methods cover the query requirements from the PDF, in the same order as posed in the PDF

    //List all goods
    public void listGoods(){
        int id, quantity, minQuantity;
        double price;
        String good;

        List<Good> goods = GoodRepository.findAll();
        for (Good row : goods){
            id = row.getId();
            quantity = row.getQuantity();
            minQuantity = row.getMinQuantity();
            price = row.getPrice();
            good = row.getGood();

            //code to be executed in the UI with given data
        }
    }

    //For getting money in register, just get directly with session.get(Register.class, 1).getBalance()

    //List purchases/sales with partners in a given period (purchase/sale should be given as a parameter(ENUM))
    //Presumably, should show: invoice id, date, partner, all purchased/sold goods in the invoice in 1 row
    public void listTransactions(Calendar start, Calendar end, Transactions transaction){
        int invoice_id;
        String partnerName, userName;
        Calendar calendar;
        List<Good> goods;

        List<Invoice> invoices = new InvoiceRepository().findByPeriod(start, end);
        for (Invoice row : invoices){
            if (row.getTransaction().getTransaction().equals(transaction)){
                invoice_id = row.getId();
                partnerName = row.getPartner().getName();
                userName = row.getUser().getName();
                calendar = row.getCalendar();
                //putting all goods of the invoice into a List for later usage(resetting on each row)
                goods = new ArrayList<>();
                for (Invoice_Good invoice_good : row.getInvoice_goods()){
                    goods.add(invoice_good.getGood());
                }

                //code to be executed in the UI with given data
            }
        }
    }

    //List all invoices, created by given user in a given period (my interpretation of the requirement)
    public void listUserActivity(Calendar start, Calendar end, User user){
        int invoice_id, user_id = user.getId();
        String partnerName, userName = user.getName();
        Calendar calendar;
        List<Good> goods;

        List<Invoice> invoices = new InvoiceRepository().findByPeriod(start, end);
        for (Invoice row : invoices){
            if (row.getUser().equals(user)){
                invoice_id = row.getId();
                partnerName = row.getPartner().getName();
                calendar = row.getCalendar();
                //putting all goods of the invoice into a List for later usage(resetting on each row)
                goods = new ArrayList<>();
                for (Invoice_Good invoice_good : row.getInvoice_goods()){
                    goods.add(invoice_good.getGood());
                }

                //code to be executed in the UI with given data
            }
        }
    }

    //Check for a specific good
    public void checkGood(String goodStr){
        List<Good> goods = GoodRepository.findByGood(goodStr);
        if (goods.isEmpty()){

            //code to be executed in the UI if the good does not exist in the database
        }
        else {
            Good good = goods.get(0);

            //code to be executed in the UI with if the good exists in the database
        }
    }

    //Getting proceed-expense-profit data for given period, kind of combining last 2 query requirements from the PDF
    public void getMonetaryResults(Calendar start, Calendar end){
        double undefined = 0, expenses = 0, proceeds = 0, profit = 0;

        List<Invoice> invoices = InvoiceRepository.findByPeriod(start, end);

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

        //code to be executed in the UI with given data
    }

    //Listing all transactions for a given period, possibly sale rows in green and purchase rows in red
    public void getMoneyFlow(Calendar start, Calendar end){
        Calendar calendar;
        double transactionValue = 0;
        String partner;

        List<Invoice> invoices = new InvoiceRepository().findByPeriod(start, end);

        for (Invoice invoice : invoices){
            calendar = invoice.getCalendar();
            partner = invoice.getPartner().getName();

            for (Invoice_Good invoice_good : invoice.getInvoice_goods()){
                transactionValue += invoice_good.getQuantity()*invoice_good.getPrice();
            }
            if (invoice.getTransaction().getTransaction().equals(Transactions.PURCHASE)){

                //code to be executed in the UI with if the transaction was a purchase
            }
            else{

                //code to be executed in the UI with if the transaction was a sale
            }
            transactionValue = 0;
        }
    }
}
