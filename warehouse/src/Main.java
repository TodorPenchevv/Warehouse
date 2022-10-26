import ORM.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Calendar;
import java.util.GregorianCalendar;


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

        Invoice invoice1 = new Invoice(new GregorianCalendar(2001, Calendar.DECEMBER,23));
        Invoice invoice2 = new Invoice(new GregorianCalendar(2002, Calendar.JANUARY,22));
        Invoice invoice3 = new Invoice(new GregorianCalendar(2001, Calendar.MARCH,11));
        Invoice invoice4 = new Invoice(new GregorianCalendar(2005, Calendar.MARCH,11));

        Transaction transaction1 = new Transaction(Transactions.PURCHASE);
        Transaction transaction2 = new Transaction(Transactions.SALE);

        transaction1.getInvoices().add(invoice1);
        transaction1.getInvoices().add(invoice2);
        transaction2.getInvoices().add(invoice3);
        transaction2.getInvoices().add(invoice4);

        user4.getInvoices().add(invoice1);
        user3.getInvoices().add(invoice2);
        user2.getInvoices().add(invoice3);
        user1.getInvoices().add(invoice4);

        partner1.getInvoices().add(invoice1);
        partner1.getInvoices().add(invoice2);
        partner2.getInvoices().add(invoice3);
        partner2.getInvoices().add(invoice4);

        Invoice_Good invoice_good1 = new Invoice_Good(1,2);
        Invoice_Good invoice_good2 = new Invoice_Good(2,3);
        Invoice_Good invoice_good3 = new Invoice_Good(3,4);
        Invoice_Good invoice_good4 = new Invoice_Good(4,5);
        Invoice_Good invoice_good5 = new Invoice_Good(5,6);
        Invoice_Good invoice_good6 = new Invoice_Good(6,7);

        invoice1.getInvoice_goods().add(invoice_good1);
        invoice1.getInvoice_goods().add(invoice_good2);
        invoice2.getInvoice_goods().add(invoice_good3);
        invoice2.getInvoice_goods().add(invoice_good4);
        invoice3.getInvoice_goods().add(invoice_good5);
        invoice4.getInvoice_goods().add(invoice_good6);

        good1.getInvoice_goods().add(invoice_good1);
        good2.getInvoice_goods().add(invoice_good2);
        good1.getInvoice_goods().add(invoice_good3);
        good2.getInvoice_goods().add(invoice_good4);
        good1.getInvoice_goods().add(invoice_good5);
        good2.getInvoice_goods().add(invoice_good6);

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
        session.save(invoice4);

        session.save(invoice_good1);
        session.save(invoice_good2);
        session.save(invoice_good3);
        session.save(invoice_good4);
        session.save(invoice_good5);
        session.save(invoice_good6);

        session.getTransaction().commit();
        
    }
}
