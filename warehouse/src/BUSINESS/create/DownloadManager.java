package BUSINESS.create;

import ORM.Role;
import org.hibernate.Session;

public class DownloadManager {
    public Object download(Session session, TABLES table, int id){
        switch (table){
            case ROLE:
                return session.get(Role.class, id);
            default:
                return null;
        }
    }
}
