package BUSINESS.create;

import BUSINESS.GetSession;
import BUSINESS.validators.GoodValidator;
import BUSINESS.validators.Price;
import BUSINESS.validators.Quantity;
import ORM.Good;
import org.hibernate.Session;

public class InsertGood {
    public static void create(String good, int quantity, double price, int minQuantity) throws Exception {
        Session session = GetSession.getSession();

        //Data validations...
        new Quantity(quantity).validate();
        new Quantity(minQuantity).validate();
        new Price(price).validate();
        new GoodValidator(good).validate();

        Good newGood = new Good(good, quantity, price, minQuantity);

        session.beginTransaction();
        session.save(newGood);
        session.getTransaction().commit();
        session.close();
    }
}
