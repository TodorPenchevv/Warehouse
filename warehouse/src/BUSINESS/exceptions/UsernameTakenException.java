package BUSINESS.exceptions;

public class UsernameTakenException extends Exception {
    public UsernameTakenException() {
        super("Потребителското име е вече заето!");
    }
}
