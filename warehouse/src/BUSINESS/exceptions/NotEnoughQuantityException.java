package BUSINESS.exceptions;

public class NotEnoughQuantityException extends Exception {
    public NotEnoughQuantityException() {
        super("Няма достатъчна наличност от избраната стока!");
    }
}
