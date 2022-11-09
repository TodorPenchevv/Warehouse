package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.*;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.List;

public class InsertInvoice implements Insert{
    public static void create(Calendar calendar, List<Good> goods, int userID, int partnerID, int transactionID){
        Session session = GetSession.getSession();
        Invoice newInvoice = new Invoice(calendar);

        session.beginTransaction();

        User user = session.get(User.class, userID);
        user.getInvoices().add(newInvoice);
        newInvoice.setUser(user);

        Partner partner = session.get(Partner.class, partnerID);
        partner.getInvoices().add(newInvoice);
        newInvoice.setPartner(partner);

        Transaction transaction = session.get(Transaction.class, transactionID);
        user.getInvoices().add(newInvoice);
        newInvoice.setTransaction(transaction);

        session.save(newInvoice);
        session.update(user);
        session.update(partner);
        session.update(transaction);

        session.getTransaction().commit();


        for (Good good : goods){
            InsertInvoiceGood.create(good.getQuantity(), good.getPrice(), newInvoice.getId(), good.getId(), session);
        }

        //Close session after all goods are added
        session.close();
    }
}
