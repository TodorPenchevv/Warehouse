package BUSINESS.exceptions;

public class GoodAlreadyExistsException extends Exception {
    public GoodAlreadyExistsException(String goodName) {
        super("Стока \"" + goodName + "\" вече съществува!");
    }
}
