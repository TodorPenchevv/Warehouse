package app.BUSINESS.exceptions;

public class DatesNotConsecutive extends CustomException {
    public DatesNotConsecutive() {
        super("Датите трябва да са последователни!");
    }
}
