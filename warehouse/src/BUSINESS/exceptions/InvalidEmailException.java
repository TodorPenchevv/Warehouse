package BUSINESS.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Въведеният имейл е в невалиден формат!");
    }
}
