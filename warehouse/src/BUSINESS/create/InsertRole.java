package BUSINESS.create;

import ORM.Role;
import ORM.Roles;

public class InsertRole implements Insert{
    public static void create(Roles role) {
        Role newRole = new Role(role);

        session.beginTransaction();
        session.save(newRole);
        session.getTransaction().commit();
    }
}
