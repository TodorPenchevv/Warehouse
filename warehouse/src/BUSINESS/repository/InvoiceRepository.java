package BUSINESS.repository;

import BUSINESS.GetSession;
import ORM.Good;
import ORM.Invoice;
import ORM.Invoice_Good;
import ORM.User;
import org.hibernate.Session;

import javax.persistence.criteria.*;
import java.util.Calendar;
import java.util.List;

public class InvoiceRepository {


    public List<Invoice> findByPeriod(Calendar start, Calendar end) {
        Session session = GetSession.getSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Invoice> criteriaQuery = criteriaBuilder.createQuery(Invoice.class);
        Root<Invoice> root = criteriaQuery.from(Invoice.class);
        criteriaQuery.where(criteriaBuilder.between(root.get("calendar"), start, end));

        List<Invoice> result = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return result;
    }

}
