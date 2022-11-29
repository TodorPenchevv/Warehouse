package app.BUSINESS.validators;

import app.BUSINESS.CurrentUser;
import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.exceptions.NotAdminException;

public class Admin implements Validator {
    int roleId = CurrentUser.getInstance().getRoleId();

    @Override
    public void validate() throws CustomException {
        if (roleId != 2) {
            throw new NotAdminException();
        }
    }
}
