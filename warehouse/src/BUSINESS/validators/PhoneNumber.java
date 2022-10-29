package BUSINESS.validators;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public boolean validate() {
        //phone number validation
            //if not valid return false
        return true;
    }
}
