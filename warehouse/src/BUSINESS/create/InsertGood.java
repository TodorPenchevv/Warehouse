package BUSINESS.create;

import BUSINESS.GetSession;
import BUSINESS.exceptions.GoodAlreadyExistsException;
import BUSINESS.repository.GoodRepository;
import BUSINESS.validators.Price;
import BUSINESS.validators.Quantity;
import ORM.Good;
import org.hibernate.Session;

import java.util.List;

public class InsertGood implements Insert{
    public static void create(String good, int quantity, double price, int minQuantity) throws Exception {
        Session session = GetSession.getSession();

        //Data validations...
        new Quantity(quantity).validate();
        new Quantity(minQuantity).validate();
        new Price(price).validate();

        //Good already exists?
        List<Good> goods = GoodRepository.findByGood(good);
        if (goods != null && !goods.isEmpty()) {
            throw new GoodAlreadyExistsException(good);
        }

        Good newGood = new Good(good, quantity, price, minQuantity);

        session.beginTransaction();
        session.save(newGood);
        session.getTransaction().commit();
        session.close();
    }
}
