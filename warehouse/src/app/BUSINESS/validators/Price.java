package app.BUSINESS.validators;

import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.exceptions.InvalidPriceException;

public class Price implements Validator {
    private double price;

    public Price(double price) {
        this.price = price;
    }

    public void validate() throws CustomException {
        if(negativePrice() || invalidPrice()) {
            throw new InvalidPriceException(0, 1000000);
        }
    }

    private boolean negativePrice() {
        return price < 0;
    }

    private boolean invalidPrice() {
        return price > 100000;
    }
}
