package app.BUSINESS.create;

import app.BUSINESS.GetSession;
import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.exceptions.RegistryAlreadyExists;
import app.BUSINESS.repository.RegisterRepository;
import app.BUSINESS.validators.Price;
import app.ORM.Register;
import org.hibernate.Session;

public class InsertRegister {
    public static void create(int id, double balance) throws CustomException {
        Session session = GetSession.getSession();

        new Price(balance).validate();
        if(RegisterRepository.getRegister() != null) throw new RegistryAlreadyExists();

        Register register = new Register(id, balance);

        session.beginTransaction();
        session.save(register);
        session.getTransaction().commit();
        session.close();
    }
}
