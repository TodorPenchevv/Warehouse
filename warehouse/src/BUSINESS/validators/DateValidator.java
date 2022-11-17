package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidDateException;

import java.util.Calendar;

public class DateValidator implements Validator {
    private Calendar date;

    public DateValidator(Calendar date) {
        this.date = date;
    }

    @Override
    public void validate() throws CustomException {
        if(invalidFormat()) {
            throw new InvalidDateException();
        }
    }

    public boolean invalidFormat() {
        return date == null;
    }
}
