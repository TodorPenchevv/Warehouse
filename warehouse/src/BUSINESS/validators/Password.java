package BUSINESS.validators;

import BUSINESS.exceptions.InvalidPassword;
import BUSINESS.exceptions.PasswordsNotMatchException;

public class Password implements Validator {
    private String password;
    private String passwordConfirm;

    public Password(String password, String passwordConfirm) {
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public boolean validate() throws Exception {
        if(passwordTooShort() || passwordNumber() || passwordCapitalLetter()) {
            throw new InvalidPassword();
        }
        if(passwordNotMatchConfirm()) {
            throw new PasswordsNotMatchException();
        }
        return true;
    }

    private boolean passwordTooShort() {
        return true;
    }

    private boolean passwordCapitalLetter() {
        return true;
    }

    private boolean passwordNumber() {
        return true;
    }

    private boolean passwordNotMatchConfirm() {
        return true;
    }
}
