package BUSINESS.create;

import ORM.Good;

public class InsertGood implements Insert{
    public static void create(String good, int quantity, double price) {
        Good newGood = new Good(good, quantity, price);

        session.beginTransaction();
        session.save(newGood);
        session.getTransaction().commit();
    }
}
