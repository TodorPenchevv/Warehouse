package BUSINESS.exceptions;

public class InvoiceTypeNotSelected extends Exception {
    public InvoiceTypeNotSelected() {
        super("Изберете дали фактурата е доставка или изписване!");
    }
}
