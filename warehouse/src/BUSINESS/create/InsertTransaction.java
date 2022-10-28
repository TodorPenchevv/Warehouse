package BUSINESS.create;

import ORM.Transaction;
import ORM.Transactions;

public class InsertTransaction implements Insert{
    public static void create(Transactions transaction) {
        Transaction newTransaction = new Transaction(transaction);

        session.beginTransaction();
        session.save(newTransaction);
        session.getTransaction().commit();
    }
}
