package BUSINESS.create;

import ORM.Partner;

public class InsertPartner implements Insert{
    public static void create(String name, String phone, String email) {
        Partner newPartner = new Partner(name, phone, email);

        session.beginTransaction();
        session.save(newPartner);
        session.getTransaction().commit();
    }
}
