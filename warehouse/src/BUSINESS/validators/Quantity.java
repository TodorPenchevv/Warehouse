package BUSINESS.validators;

public class Quantity implements Validator {
    private String quantity;

    public Quantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean validate() {
        //quantity validation
            //if not valid return false
        return true;
    }
}
