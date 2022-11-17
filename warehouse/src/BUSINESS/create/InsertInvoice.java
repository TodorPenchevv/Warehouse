package BUSINESS.create;

import BUSINESS.GetSession;
import BUSINESS.exceptions.NotEnoughQuantityException;
import BUSINESS.validators.Balance;
import BUSINESS.validators.DateValidator;
import BUSINESS.validators.GoodQuantity;
import ORM.*;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.List;

public class InsertInvoice implements Insert{
    public static void create(Calendar calendar, List<Good> goods, int userID, int partnerID, Transactions transactionName) throws Exception{
        Session session = GetSession.getSession();
        Invoice newInvoice = new Invoice(calendar);

        if(transactionName.equals(Transactions.SALE)) {
            //If we are selling...
            //Validate goods quantity is enough
            new GoodQuantity(goods).validate();
        }
        else {
            //If we are buying...
            //Validate we have enough money
            new Balance(goods).validate();
        }
        new DateValidator(calendar).validate();

        session.beginTransaction();

        User user = session.get(User.class, userID);
        user.getInvoices().add(newInvoice);
        newInvoice.setUser(user);

        Partner partner = session.get(Partner.class, partnerID);
        partner.getInvoices().add(newInvoice);
        newInvoice.setPartner(partner);

        int transactionId = 1;
        if(transactionName.equals(Transactions.PURCHASE))
              transactionId = 2;

        Transaction transaction = session.get(Transaction.class, transactionId);
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
