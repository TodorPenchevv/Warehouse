package BUSINESS.validators;

public class Email implements Validator {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public boolean validate() {
        //email validation
            //if not valid return false
        return true;
    }
}
