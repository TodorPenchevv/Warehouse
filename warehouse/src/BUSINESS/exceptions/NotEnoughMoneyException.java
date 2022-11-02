package BUSINESS.exceptions;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("В касата няма достатъчно пари!");
    }
}
