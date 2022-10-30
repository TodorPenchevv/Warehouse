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
        Root<User> userRoot = criteriaQuery.from(User.class);

        //Selecting user by username
        criteriaQuery.where(
                criteriaBuilder.equal(userRoot.get("username"), username)
        );

        //Setting Users table for the select
        CriteriaQuery<User> select = criteriaQuery.select(userRoot);
        //Creating Hibernate typed query with session
        TypedQuery<User> query = session.createQuery(select);

        //Getting only one result
        query.setFirstResult(0);
        query.setMaxResults(1);

        //Return list of results
        List<User> results = query.getResultList();

        session.close();
        return results;
    }
}
