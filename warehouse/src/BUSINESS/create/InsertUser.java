package BUSINESS.create;

import ORM.Role;
import ORM.User;

public class InsertUser implements Insert {
    public static void create(String name, String username, String password, int roleID) {
        System.out.println("In insert method...");

        //Creating the user object with the data
        //Some sort of data validation before this step...
        User user = new User(name, username, password);

        //Transaction begins now, because we need to update "ROLES" object with PK "roleID" in order
        //to create the FK column in the new row we are currently creating with said "roleID" PK
        session.beginTransaction();

        //Role role = session.get(Role.class, roleID);
        //role.getUsers().add(user);

        //Updating row "role" and saving the new row "user"
        //session.update(role);
        session.save(user);
        session.getTransaction().commit();
    }
}
