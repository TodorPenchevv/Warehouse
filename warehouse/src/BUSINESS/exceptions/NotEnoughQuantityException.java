package BUSINESS.exceptions;

public class NotEnoughQuantityException extends CustomException {
    public NotEnoughQuantityException(String good) {
        super("Няма достатъчна наличност от " + good + "!");
    }
}
