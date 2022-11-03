package BUSINESS.exceptions;

public class PasswordsNotMatchException extends Exception {
    public PasswordsNotMatchException() {
        super("Паролата за потвърждение не съвпада!");
    }
}
