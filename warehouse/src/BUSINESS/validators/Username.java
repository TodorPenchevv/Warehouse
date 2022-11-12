package BUSINESS.validators;

import BUSINESS.exceptions.UsernameTakenException;

public class Username implements Validator {
    private String username;

    public Username(String username) {
        this.username = username;
    }

    @Override
    public boolean validate() throws Exception {
        if(usernameExists()) {
            throw new UsernameTakenException();
        }
        return true;
    }

    public boolean usernameExists() {
        return true;
    }
}
