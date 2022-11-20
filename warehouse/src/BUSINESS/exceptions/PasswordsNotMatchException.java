package BUSINESS.exceptions;

public class PasswordsNotMatchException extends CustomException {
    public PasswordsNotMatchException() {
        super("Паролата за потвърждение не съвпада!");
    }
}
