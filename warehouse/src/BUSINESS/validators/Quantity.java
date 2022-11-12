package BUSINESS.validators;

import BUSINESS.exceptions.NegativeNumberException;

public class Quantity implements Validator {
    private String quantity;

    public Quantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean validate() throws Exception {
        if(negativeQuantity()) {
            throw new NegativeNumberException("Количеството");
        }
        return true;
    }

    private boolean negativeQuantity() {
        return true;
    }
}
