package BUSINESS.exceptions;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super("Телефонът е в невалиден формат!");
    }
}
