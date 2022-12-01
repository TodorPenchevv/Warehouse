package test.BUSINESS.validators;

import app.BUSINESS.exceptions.InvalidPassword;
import app.BUSINESS.exceptions.PasswordsNotMatchException;
import app.BUSINESS.validators.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    void correctPassword() {
        assertDoesNotThrow(() -> {
                new Password("Password123", "Password123").validate();
        });
    }

    @Test
    void noUppercasePassword() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("password123", "Password123").validate();
        });
    }

    @Test
    void noLowercasePassword() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("PASSWORD123", "Password123").validate();
        });
    }

    @Test
    void noNumbersPassword() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("Password", "Password123").validate();
        });
    }

    @Test
    void tooShortPassword() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("Passwor", "Password123").validate();
        });
    }

    @Test
    void notMatchingPassword() {
        assertThrows(PasswordsNotMatchException.class, () -> {
            new Password("Password123", "Password124").validate();
        });
    }
}