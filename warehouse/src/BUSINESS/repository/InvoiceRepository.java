package BUSINESS.repository;

import BUSINESS.GetSession;
import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidDateException;
import GUI.AlertBox;
import ORM.Invoice;
import org.hibernate.Session;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class InvoiceRepository {
    public static List<Invoice> findByPeriod(LocalDate start, LocalDate end) throws CustomException {
        Session session = GetSession.getSession();

        //TO BE MOVED IN DataValidator --------------------------------
        //Validate LocalDate not null
        if(start == null || end == null) {
            throw new InvalidDateException();
        }

        //Check if dates are chronologically correct
        if(start.isAfter(end)) {
            LocalDate tempDate = start;
            start = end;
            end = tempDate;
        }

        Calendar startDate = new GregorianCalendar(start.getYear(), start.getMonthValue() - 1, start.getDayOfMonth());
        Calendar endDate = new GregorianCalendar(end.getYear(), end.getMonthValue() - 1, end.getDayOfMonth());
        //-------------------------------------------

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Invoice> criteriaQuery = criteriaBuilder.createQuery(Invoice.class);
        Root<Invoice> root = criteriaQuery.from(Invoice.class);
        criteriaQuery.where(criteriaBuilder.between(root.get("calendar"), startDate, endDate));

        List<Invoice> result = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return result;
    }
}
