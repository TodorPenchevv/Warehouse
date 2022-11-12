package BUSINESS.exceptions;

public class NegativeNumberException extends Exception {
    public NegativeNumberException(String item) {
        super(item + " трябва да е положително число!");
    }
}
