package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidEmailException;
import BUSINESS.exceptions.PartnerMailExistsException;

public class Email implements Validator {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public void validate() throws CustomException {
        if(!validFormat()) {
            throw new InvalidEmailException();
        }
        if(!unique()) {
            throw new PartnerMailExistsException();
        }
    }

    private boolean validFormat() {
        return true;
    }

    private boolean unique() {
        return true;
    }
}
