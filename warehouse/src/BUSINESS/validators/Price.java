package BUSINESS.validators;

import BUSINESS.exceptions.InvalidPriceException;
import BUSINESS.exceptions.NegativeNumberException;

public class Price implements Validator {
    private double price;

    public Price(double price) {
        this.price = price;
    }

    public boolean validate() throws Exception {
        if(negativePrice() || invalidPrice()) {
            throw new InvalidPriceException(0, 100000);
        }
        return true;
    }

    private boolean negativePrice() {
        return price < 0;
    }

    private boolean invalidPrice() {
        return price > 100000;
    }
}
