package BUSINESS.validators;

public class Name implements Validator {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean validate() {
        //name validation
            //if not valid return false
        return true;
    }
}
