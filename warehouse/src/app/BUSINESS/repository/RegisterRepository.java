package app.BUSINESS.repository;

import app.BUSINESS.GetSession;
import app.ORM.Register;
import org.hibernate.Session;

public class RegisterRepository {
    public static Register getRegister() {
        Session session = GetSession.getSession();
        Register register = session.get(Register.class, 1);
        session.close();
        return register;
    }
}
