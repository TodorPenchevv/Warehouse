package app.BUSINESS;

import app.BUSINESS.create.InsertRole;
import app.BUSINESS.create.InsertTransaction;
import app.BUSINESS.create.InsertUser;
import app.BUSINESS.repository.UserRepository;
import app.LOGGING.ErrorLogging;
import app.LOGGING.ExceptionToString;
import app.ORM.Roles;
import app.ORM.Transactions;
import app.ORM.User;
import org.hibernate.Session;

import java.util.List;

public class InitializeData {
    public InitializeData() {
        List<User> users = UserRepository.findAll();
        if(users == null || users.isEmpty()) {
            initializeConnection();
            initializeRoles();
            initializeTransactions();
            initializeAdmin();
        }
    }

    private void initializeRoles() {
        InsertRole.create(1, Roles.OPERATOR);
        InsertRole.create(2, Roles.MANAGER);
    }

    private void initializeTransactions() {
        InsertTransaction.create(1, Transactions.SALE);
        InsertTransaction.create(2, Transactions.PURCHASE);
    }

    private void initializeAdmin() {
        try {
            InsertUser.create("Admin", "admin", "Admin123", "Admin123", 2);
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }

    private void initializeConnection(){
        Session session = GetSession.getSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
    }
}
