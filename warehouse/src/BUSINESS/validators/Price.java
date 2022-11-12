package BUSINESS.validators;

import BUSINESS.exceptions.InvalidPriceException;
import BUSINESS.exceptions.NegativeNumberException;

public class Price implements Validator {
    private String price;

    public Price(String price) {
        this.price = price;
    }

    public boolean validate() throws Exception {
        if(negativePrice() || invalidPrice()) {
            throw new InvalidPriceException(0, 100000);
        }
        return true;
    }

    private boolean negativePrice() {
        return true;
    }

    private boolean invalidPrice() {
        return true;
    }
}
