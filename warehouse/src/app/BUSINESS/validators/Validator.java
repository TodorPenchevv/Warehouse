package app.BUSINESS.validators;

import app.BUSINESS.exceptions.CustomException;

public interface Validator {
    void validate() throws CustomException;
}
