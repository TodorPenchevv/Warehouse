package BUSINESS.create;

import BUSINESS.GetSession;
import ORM.Role;
import ORM.Roles;
import org.hibernate.Session;

public class InsertRole implements Insert{
    public static void create(Roles role) {
        Session session = GetSession.getSession();

        Role newRole = new Role(role);

        session.beginTransaction();
        session.save(newRole);
        session.getTransaction().commit();
        session.close();
    }
}
