package BUSINESS.exceptions;

public class PartnerMailExistsException extends Exception {
    public PartnerMailExistsException() {
        super("Този имейл принадлежи на друга фирма");
    }
}
