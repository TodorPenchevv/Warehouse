package BUSINESS.create;

import ORM.Good;
import ORM.Invoice;
import ORM.Invoice_Good;

public class InsertInvoiceGood implements Insert{
    public static void create(int quantity, double price, int invoiceID, int goodID) {

        Invoice_Good newInvoiceGood = new Invoice_Good(quantity, price);

        session.beginTransaction();

        Invoice invoice = session.get(Invoice.class, invoiceID);
        invoice.getInvoice_goods().add(newInvoiceGood);
        Good good = session.get(Good.class, goodID);
        good.getInvoice_goods().add(newInvoiceGood);

        session.update(invoice);
        session.update(good);
        session.save(newInvoiceGood);
        session.getTransaction().commit();
    }
}
