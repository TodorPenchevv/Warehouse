package BUSINESS.create;

import ORM.Good;

public class InsertGood implements Insert{
    public static void create(String good, int quantity, double price) {
        //Data validation...
        //quantity not negative nubmer, not more than 100k
        //price not negative number, not more than a million...

        Good newGood = new Good(good, quantity, price);

        session.beginTransaction();
        session.save(newGood);
        session.getTransaction().commit();
    }
}
