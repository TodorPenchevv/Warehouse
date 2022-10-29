package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Register;
import org.hibernate.Session;

public class InsertRegister implements Insert{
    public static void create(int id, double balance) {
        Session session = GetSession.getSession();

        Register register = new Register(id, balance);

        session.beginTransaction();
        session.save(register);
        session.getTransaction().commit();
        session.close();
    }
}
