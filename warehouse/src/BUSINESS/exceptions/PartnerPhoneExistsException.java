package BUSINESS.exceptions;

public class PartnerPhoneExistsException extends Exception {
    public PartnerPhoneExistsException() {
        super("Телефонният номер принадлежи на друг партньор!");
    }
}
