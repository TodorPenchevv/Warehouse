package BUSINESS.exceptions;

public class RegistryAlreadyExists extends Exception {
    public RegistryAlreadyExists() {
        super("Касата вече е създадена!");
    }
}
