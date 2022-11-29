package app.BUSINESS.exceptions;

public class RegistryAlreadyExists extends CustomException {
    public RegistryAlreadyExists() {
        super("Касата вече е създадена!");
    }
}
