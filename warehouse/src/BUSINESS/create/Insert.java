package BUSINESS.create;

import BUSINESS.HibernateConnection;
import org.hibernate.Session;

public interface Insert {
    Session session = HibernateConnection.getInstance().getSession();
}
