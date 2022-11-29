package test.BUSINESS.validators;

import app.BUSINESS.exceptions.InvalidDateException;
import app.BUSINESS.validators.DateValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {

    @Test
    void validDate() {
        LocalDate date = LocalDate.of(2001, Month.APRIL, 1);

        assertDoesNotThrow(() -> {
            new DateValidator(date).validate();
        });

    }

    @Test
    void invalidDate() {
        LocalDate date = null;

        assertThrows(InvalidDateException.class, () -> {
            new DateValidator(date).validate();
        });
    }
}