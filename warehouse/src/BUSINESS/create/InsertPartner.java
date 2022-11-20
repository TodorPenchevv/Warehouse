package BUSINESS.create;

import BUSINESS.GetSession;
import BUSINESS.exceptions.CustomException;
import BUSINESS.validators.Email;
import BUSINESS.validators.PartnerName;
import BUSINESS.validators.PhoneNumber;
import ORM.Partner;
import org.hibernate.Session;

public class InsertPartner implements Insert {
    public static void create(String name, String phone, String email) throws CustomException {
        Session session = GetSession.getSession();

        //Data validation...
        new PartnerName(name).validate();
        new Email(email).validate();
        new PhoneNumber(phone).validate();

        Partner newPartner = new Partner(name, phone, email);

        session.beginTransaction();
        session.save(newPartner);
        session.getTransaction().commit();
        session.close();
    }
}
