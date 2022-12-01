package test.BUSINESS.create;

import app.BUSINESS.GetSession;
import app.BUSINESS.create.InsertUser;
import app.BUSINESS.repository.GoodRepository;
import app.BUSINESS.repository.UserRepository;
import app.ORM.Good;
import app.ORM.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertUserTest {
    @Test
    void successfullyCreatedUser() {
        //Assert creating user with valid data
        //does not throw any exceptions
        assertDoesNotThrow(() -> {
            InsertUser.create("Test User 1", "testusername1", "Password123", "Password123", 2);
        });

        //Assert that the user was saved successfully in the database
        List<User> users = UserRepository.findByUsername("testusername1");
        assertEquals("testusername1", users.get(0).getUsername());

        //Remove the test user
        deleteTestUser();
    }

    void deleteTestUser() {
        Session session = GetSession.getSession();

        List<User> users = UserRepository.findByUsername("testusername1");

        session.beginTransaction();
        session.delete(users.get(0));
        session.getTransaction().commit();
        session.close();
    }
}