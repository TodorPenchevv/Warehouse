package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Transaction;
import ORM.Transactions;
import org.hibernate.Session;

public class InsertTransaction {
    public static void create(int id, Transactions transaction) {
        Session session = GetSession.getSession();

        Transaction newTransaction = new Transaction(id, transaction);

        session.beginTransaction();
        session.save(newTransaction);
        session.getTransaction().commit();
        session.close();
    }
}
