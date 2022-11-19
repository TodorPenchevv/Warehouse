package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.InvalidDateException;

import java.time.LocalDate;

public class DateValidator implements Validator {
    private LocalDate date;

    public DateValidator(LocalDate date) {
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

