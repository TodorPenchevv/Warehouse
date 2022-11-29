package app.BUSINESS.create;

import app.BUSINESS.GetSession;
import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.validators.Email;
import app.BUSINESS.validators.PartnerName;
import app.BUSINESS.validators.PhoneNumber;
import app.ORM.Partner;
import org.hibernate.Session;

public class InsertPartner {
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
