import ORM.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Momo","Momo","123");
        User user2 = new User("Momo1","Momo1","124");
        User user3 = new User("Momo2","Momo2","125");
        User user4 = new User("Momo3","Momo3","126");
        Role role1 = new Role(Roles.MANAGER);
        Role role2 = new Role(Roles.OPERATOR);
        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role1.getUsers().add(user3);
        role2.getUsers().add(user4);
        Register register = new Register(1,123);
        Good good1 = new Good("Mlqko", 20, 150);
        Good good2 = new Good("Mlqko123", 220, 1520);

        Partner partner1 = new Partner("koko", "0891294312", "wuehbfwiubf");
        Partner partner2 = new Partner("koko123", "0892313211294312", "wuehb12311fwiubf");

        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        Invoice invoice3 = new Invoice();

        Transaction transaction1 = new Transaction(Transactions.PURCHASE);
        Transaction transaction2 = new Transaction(Transactions.SALE);

        transaction1.getInvoices().add(invoice1);
        transaction1.getInvoices().add(invoice2);
        transaction2.getInvoices().add(invoice3);

        user4.getInvoices().add(invoice1);
        user3.getInvoices().add(invoice2);
        user2.getInvoices().add(invoice3);

        partner1.getInvoices().add(invoice1);
        partner1.getInvoices().add(invoice2);
        partner2.getInvoices().add(invoice3);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(role1);
        session.save(role2);
        session.save(register);
        session.save(good2);
        session.save(good1);

        session.save(partner1);
        session.save(partner2);

        session.save(transaction1);
        session.save(transaction2);

        session.save(invoice1);
        session.save(invoice2);
        session.save(invoice3);

        session.getTransaction().commit();



    }
}
