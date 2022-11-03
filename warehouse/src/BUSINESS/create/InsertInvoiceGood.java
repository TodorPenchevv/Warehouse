package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.*;
import org.hibernate.Session;

public class InsertInvoiceGood implements Insert{
    public static void create(int quantity, double price, int invoiceID, int goodID, Session session) {
        Invoice_Good newInvoiceGood = new Invoice_Good(quantity, price);

        session.beginTransaction();

        Invoice invoice = session.get(Invoice.class, invoiceID);
        invoice.getInvoice_goods().add(newInvoiceGood);
        newInvoiceGood.setInvoice(invoice);

        Good good = session.get(Good.class, goodID);
        good.getInvoice_goods().add(newInvoiceGood);
        newInvoiceGood.setGood(good);

        Register register = session.get(Register.class, 1);

        double newBalance;
        int newQuantity;
        if (invoice.getTransaction().getTransaction() == Transactions.PURCHASE){
            newBalance = register.getBalance() - quantity*price;
            newQuantity = good.getQuantity() + quantity;
        }
        else{
            newBalance = register.getBalance() + quantity*price;
            newQuantity = good.getQuantity() - quantity;
        }

        register.setBalance(newBalance);
        good.setQuantity(newQuantity);

        session.save(newInvoiceGood);
        session.update(invoice);
        session.update(good);
        session.update(register);
        session.getTransaction().commit();
    }
}
