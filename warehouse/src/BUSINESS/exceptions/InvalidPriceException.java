package BUSINESS.exceptions;

public class InvalidPriceException extends Exception {
    public InvalidPriceException(double min, double max) {
        super("Цената трябва да е между " + min + " и " + max + "!");
    }
}
