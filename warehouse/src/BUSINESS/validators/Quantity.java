package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.NegativeNumberException;

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
