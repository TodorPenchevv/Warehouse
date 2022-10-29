package BUSINESS.validators;

public class Price implements Validator {
    private String price;

    public Price(String price) {
        this.price = price;
    }

    public boolean validate() {
        //price validation
            //if not valid return false
        return true;
    }
}
