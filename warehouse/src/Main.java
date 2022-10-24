import ORM.Roles;
import ORM.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args) {

        Roles role1 = new Roles("momo2");
        Users users1 = new Users("kaloqn");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(role1);
        session.save(users1);
        session.getTransaction().commit();



    }
}
