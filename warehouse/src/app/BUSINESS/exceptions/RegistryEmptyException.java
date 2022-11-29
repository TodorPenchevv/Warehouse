package app.BUSINESS.exceptions;

public class RegistryEmptyException extends CustomException {
    public RegistryEmptyException() {
        super("Няма създадена каса!");
    }
}
