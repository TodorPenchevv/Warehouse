package BUSINESS.exceptions;

public class InvalidPriceException extends Exception {
    public InvalidPriceException(int min, int max) {
        super("Цената трябва да е между " + min + " и " + max + "!");
    }
}
