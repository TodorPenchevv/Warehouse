package BUSINESS.exceptions;

public class InvalidDateException extends Exception {
    public InvalidDateException() {
        super("Веведените дати са в невалиден формат!");
    }
}
