package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Transaction;
import ORM.Transactions;
import org.hibernate.Session;

public class InsertTransaction implements Insert{
    public static void create(Transactions transaction) {
        Session session = GetSession.getSession();

        Transaction newTransaction = new Transaction(transaction);

        session.beginTransaction();
        session.save(newTransaction);
        session.getTransaction().commit();
        session.close();
    }
}
