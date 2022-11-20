package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;

public interface Validator {
    void validate() throws CustomException;
}
