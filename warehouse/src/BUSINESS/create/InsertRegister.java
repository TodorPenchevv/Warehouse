package BUSINESS.create;

import ORM.Register;

public class InsertRegister implements Insert{
    public static void create(int id, double balance) {
        Register register = new Register(id, balance);

        session.beginTransaction();
        session.save(register);
        session.getTransaction().commit();
    }
}
