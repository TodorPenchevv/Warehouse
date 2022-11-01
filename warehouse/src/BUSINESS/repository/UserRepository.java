package BUSINESS.repository;

import BUSINESS.GetSession;
import ORM.User;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository implements Repository {

    public User findById(int id) {
        Session session = GetSession.getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> findByUsername(String username) {
        Session session = GetSession.getSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.like(root.get("username"), username));

        List<User> result = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return result;
    }
}
