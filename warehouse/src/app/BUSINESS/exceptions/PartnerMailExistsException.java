package app.BUSINESS.exceptions;

public class PartnerMailExistsException extends CustomException {
    public PartnerMailExistsException() {
        super("Този имейл принадлежи на друга фирма");
    }
}
