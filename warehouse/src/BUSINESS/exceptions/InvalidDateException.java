package BUSINESS.exceptions;

public class InvalidDateException extends CustomException {
    public InvalidDateException() {
        super("Веведените дати са в невалиден формат!");
    }
}
