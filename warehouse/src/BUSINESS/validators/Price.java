package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidPriceException;
import BUSINESS.exceptions.NegativeNumberException;

public class Price implements Validator {
    private double price;

    public Price(double price) {
        this.price = price;
    }

    public void validate() throws CustomException {
        if(negativePrice() || invalidPrice()) {
            throw new InvalidPriceException(0, 100000);
        }
    }

    private boolean negativePrice() {
        return price < 0;
    }

    private boolean invalidPrice() {
        return price > 100000;
    }
}
