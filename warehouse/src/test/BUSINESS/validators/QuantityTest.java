package test.BUSINESS.validators;

import app.BUSINESS.exceptions.NegativeNumberException;
import app.BUSINESS.validators.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    void validQuantity() {
        assertDoesNotThrow(() -> {
            new Quantity(100).validate();
        });
    }

    @Test
    void invalidQuantity() {
        assertThrows(NegativeNumberException.class, () -> {
            new Quantity(-100).validate();
        });
    }
}