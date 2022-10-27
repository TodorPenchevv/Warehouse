package BUSINESS.create;

import BUSINESS.create.generators.RoleGenerator;
import BUSINESS.create.generators.UserGenerator;
import org.hibernate.Session;

//Menu to choose what data to insert
//To avoid creating sessions every time an object is inserted, one main session is created in main
//and is then passed to all methods and classes who need it to function
public class InsertManager {
    public void insert(Session session, TABLES table){ //GUI INSERT(TABLES table)
        switch (table){
            case ROLE:
                new RoleGenerator().generate(session);
                break;
            case USER:
                new UserGenerator().generate(session);
                break;
            default:
                System.out.println("KYS");
                break;
        }
    }
}
