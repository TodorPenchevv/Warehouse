package BUSINESS.create;

import ORM.*;

import java.util.Calendar;
import java.util.List;

public class InsertInvoice implements Insert{
    public static void create(Calendar calendar, List<TempGood> goods, int userID, int partnerID){
        Invoice newInvoice = new Invoice(calendar);

        session.beginTransaction();

        User user = session.get(User.class, userID);
        user.getInvoices().add(newInvoice);
        Partner partner = session.get(Partner.class, partnerID);
        partner.getInvoices().add(newInvoice);

        session.save(newInvoice);
        session.getTransaction().commit();
        
        for (TempGood good : goods){
            InsertInvoiceGood.create(good.getQuantity(), good.getPrice(), newInvoice.getId(), good.getId());
        }
    }
}
