package test.BUSINESS.validators;

import app.BUSINESS.exceptions.InvalidPriceException;
import app.BUSINESS.validators.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void validPrice() {
        assertDoesNotThrow(() -> {
            new Price(199.99).validate();
        });
    }

    @Test
    void invalidPrice() {
        assertThrows(InvalidPriceException.class, () -> {
            new Price(10000099.99).validate();
        });
    }

    @Test
    void negativePrice() {
        assertThrows(InvalidPriceException.class, () -> {
            new Price(-199.99).validate();
        });
    }
}