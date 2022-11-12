package BUSINESS.validators;

import BUSINESS.exceptions.InvalidEmailException;
import BUSINESS.exceptions.PartnerMailExistsException;

public class Email implements Validator {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public boolean validate() throws Exception {
        if(!validFormat()) {
            throw new InvalidEmailException();
        }
        if(!unique()) {
            throw new PartnerMailExistsException();
        }
        return true;
    }

    private boolean validFormat() {
        return true;
    }

    private boolean unique() {
        return true;
    }
}
