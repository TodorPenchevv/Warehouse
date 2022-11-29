package app.BUSINESS.exceptions;

public class InvoiceTypeNotSelected extends CustomException {
    public InvoiceTypeNotSelected() {
        super("Изберете дали фактурата е доставка или изписване!");
    }
}
