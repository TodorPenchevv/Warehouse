package BUSINESS.exceptions;

public class PartnerAlreadyExistsException extends CustomException {
    public PartnerAlreadyExistsException() {
        super("Фирма с такова име вече съществува!");
    }
}
