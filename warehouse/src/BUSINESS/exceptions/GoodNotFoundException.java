package BUSINESS.exceptions;

public class GoodNotFoundException extends Exception {
    public GoodNotFoundException(String goodName) {
        super(goodName + " не съществува в списъка със стоки!");
    }
}
