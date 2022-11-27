package BUSINESS;

import BUSINESS.create.InsertRole;
import BUSINESS.create.InsertTransaction;
import BUSINESS.create.InsertUser;
import BUSINESS.repository.UserRepository;
import LOGGING.ErrorLogging;
import LOGGING.ExceptionToString;
import ORM.Roles;
import ORM.Transactions;
import ORM.User;
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
