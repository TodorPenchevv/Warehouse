package app.BUSINESS.validators;

import app.BUSINESS.exceptions.NegativeNumberException;
import app.BUSINESS.exceptions.CustomException;

public class Quantity implements Validator {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public void validate() throws CustomException {
        if(negativeQuantity()) {
            throw new NegativeNumberException("Количеството");
        }
    }

    private boolean negativeQuantity() {
        return quantity < 0;
    }
}
