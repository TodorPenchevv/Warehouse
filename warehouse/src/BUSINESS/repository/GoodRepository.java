package BUSINESS.repository;

import BUSINESS.GetSession;
import ORM.Good;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GoodRepository {

    public List<Good> findAll(){
        Session session = GetSession.getSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Good> criteriaQuery = criteriaBuilder.createQuery(Good.class);
        criteriaQuery.from(Good.class);

        List<Good> result = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return result;
    }
}
