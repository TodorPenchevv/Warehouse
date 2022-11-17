package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidPhoneNumberException;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public void validate() throws CustomException {
        if(!validFormat()) {
            throw new InvalidPhoneNumberException();
        }
    }

    private boolean validFormat() {
        return true;
    }
}
