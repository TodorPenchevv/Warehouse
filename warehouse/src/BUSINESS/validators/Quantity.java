package BUSINESS.validators;

import BUSINESS.exceptions.NegativeNumberException;

public class Quantity implements Validator {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean validate() throws Exception {
        if(negativeQuantity()) {
            throw new NegativeNumberException("Количеството");
        }
        return true;
    }

    private boolean negativeQuantity() {
        return quantity < 0;
    }
}
