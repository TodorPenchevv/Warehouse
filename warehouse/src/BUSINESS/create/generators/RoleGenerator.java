package BUSINESS.create.generators;

import ORM.Role;
import ORM.Roles;
import org.hibernate.Session;

public class RoleGenerator {
    //Function creating and saving the new "Role" row in table "ROWS"
    public void generate(Session session){
        Roles role = Roles.OPERATOR; //GUI INSERT
        Role newRole = new Role(role);

        session.beginTransaction();
        session.save(newRole);
        session.getTransaction().commit();
    }
}
