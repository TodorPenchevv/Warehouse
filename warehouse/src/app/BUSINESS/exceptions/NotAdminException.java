package app.BUSINESS.exceptions;

public class NotAdminException extends CustomException {
    public NotAdminException() {
        super("Този акаунт няма достъп до тази операция!");
    }
}
