package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Good;
import org.hibernate.Session;

public class InsertGood implements Insert{
    public static void create(String good, int quantity, double price) {
        Session session = GetSession.getSession();

        //Data validation...
        //quantity not negative nubmer, not more than 100k
        //price not negative number, not more than a million...

        Good newGood = new Good(good, quantity, price);

        session.beginTransaction();
        session.save(newGood);
        session.getTransaction().commit();
        session.close();
    }
}
