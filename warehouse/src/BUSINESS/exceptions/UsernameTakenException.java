package BUSINESS.exceptions;

public class UsernameTakenException extends CustomException {
    public UsernameTakenException() {
        super("Потребителското име е вече заето!");
    }
}
