package BUSINESS.validators;

import BUSINESS.CurrentUser;
import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.NotAdminException;

public class Admin implements Validator {
    int roleId = CurrentUser.getInstance().getRoleId();

    @Override
    public void validate() throws CustomException {
        if(roleId != 2) {
            throw new NotAdminException();
        }
    }
}
