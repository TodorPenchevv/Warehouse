package BUSINESS.validators;

import BUSINESS.exceptions.InvalidPhoneNumberException;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public boolean validate() throws Exception {
        if(!validFormat()) {
            throw new InvalidPhoneNumberException();
        }
        return true;
    }

    private boolean validFormat() {
        return true;
    }
}
