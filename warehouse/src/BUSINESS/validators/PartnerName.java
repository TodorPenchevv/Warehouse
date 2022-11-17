package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;

public class PartnerName implements Validator {
    private String name;

    public PartnerName(String name) {
        this.name = name;
    }

    public void validate() throws CustomException {
        //name validation
            //if not valid return false
    }
}
