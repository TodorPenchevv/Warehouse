package BUSINESS.create.generators;

import BUSINESS.create.DownloadManager;
import BUSINESS.create.TABLES;
import ORM.Role;
import ORM.User;
import org.hibernate.Session;

public class UserGenerator {

    public void generate(Session session){
        //Getting data for new user from GUI
        String name="momo";     //GUI INSERT
        String username="konq"; //GUI INSERT
        String password="123"; //GUI INSERT
        int roleID = 1; // (1=operator) GUI INSERT

        //Creating the user object with the data
        User user = new User(name, username, password);

        //Transaction begins now, because we need to update "ROLES" object with PK "roleID" in order
        //to create the FK column in the new row we are currently creating with said "roleID" PK
        session.beginTransaction();

        //Downloading Role object with the given PK, adding the new User to the role's ArrayList in order to create the FK
        //column into the new user row with the value of the role's PK
        Role role = (Role) DownloadManager.download(session, TABLES.ROLE, roleID);
        role.getUsers().add(user);

        //Updating row "role" and saving the new row "user"
        session.update(role);
        session.save(user);
        session.getTransaction().commit();
    }
}
