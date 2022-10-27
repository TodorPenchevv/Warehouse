package BUSINESS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private static HibernateConnection instance = null;
    public static Session session;

    private HibernateConnection()
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static HibernateConnection getInstance()
    {
        if (instance == null)
            instance = new HibernateConnection();

        return instance;
    }

    public void disconnect() {
        session.close();
    }

    public Session getSession() {
        return session;
    }
}
