package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Partner;
import org.hibernate.Session;

public class InsertPartner implements Insert{
    public static void create(String name, String phone, String email) {
        Session session = GetSession.getSession();

        //Data validation...
        //Is the phone in phone format, the email in email format...

        Partner newPartner = new Partner(name, phone, email);

        session.beginTransaction();
        session.save(newPartner);
        session.getTransaction().commit();
        session.close();
    }
}
