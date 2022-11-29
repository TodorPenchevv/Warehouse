package test.BUSINESS.validators;

import app.BUSINESS.CurrentUser;
import app.BUSINESS.exceptions.NotAdminException;
import app.BUSINESS.validators.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void userIsAdmin() {
        CurrentUser.getInstance().login(1, 2);
        assertDoesNotThrow(() -> {
            new Admin().validate();
        });
    }

    @Test
    void userIsNotAdmin() {
        CurrentUser.getInstance().login(1, 1);
        assertThrows(NotAdminException.class, () -> {
            new Admin().validate();
        });
    }
}