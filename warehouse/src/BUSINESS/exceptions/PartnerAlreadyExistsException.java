package BUSINESS.exceptions;

public class PartnerAlreadyExistsException extends Exception {
    public PartnerAlreadyExistsException() {
        super("Фирма с такова име вече съществува!");
    }
}
