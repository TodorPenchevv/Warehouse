package BUSINESS;

import BUSINESS.create.InsertRole;
import BUSINESS.create.InsertTransaction;
import BUSINESS.create.InsertUser;
import BUSINESS.repository.UserRepository;
import LOGGING.ErrorLogging;
import ORM.Roles;
import ORM.Transactions;
import ORM.User;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.List;

public class InitializeData {
    private static final Marker initializeDataMarker = MarkerManager.getMarker("InitializeData");

    public InitializeData() {
        List<User> users = UserRepository.findAll();
        if(users == null || users.isEmpty()) {
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
            new ErrorLogging().log(initializeDataMarker, e.getMessage());
        }
    }
}
