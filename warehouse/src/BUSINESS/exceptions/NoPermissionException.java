package BUSINESS.exceptions;

public class NoPermissionException extends Exception {
    public NoPermissionException() {
        super("Нямаш нужните права за тази операция!");
    }
}
