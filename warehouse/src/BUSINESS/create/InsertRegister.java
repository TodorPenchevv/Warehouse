package BUSINESS.create;

import BUSINESS.GetSession;
import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.RegistryAlreadyExists;
import BUSINESS.repository.RegisterRepository;
import BUSINESS.validators.Price;
import ORM.Register;
import org.hibernate.Session;

public class InsertRegister implements Insert{
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
