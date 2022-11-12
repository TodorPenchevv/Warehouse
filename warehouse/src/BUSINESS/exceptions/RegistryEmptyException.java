package BUSINESS.exceptions;

public class RegistryEmptyException extends Exception {
    public RegistryEmptyException() {
        super("Няма създадена каса!");
    }
}
