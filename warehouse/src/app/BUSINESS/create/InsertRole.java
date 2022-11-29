package app.BUSINESS.create;

import app.BUSINESS.GetSession;
import app.ORM.Role;
import app.ORM.Roles;
import org.hibernate.Session;

public class InsertRole {
    public static void create(int id, Roles role) {
        Session session = GetSession.getSession();

        Role newRole = new Role(id, role);

        session.beginTransaction();
        session.save(newRole);
        session.getTransaction().commit();
        session.close();
    }
}
