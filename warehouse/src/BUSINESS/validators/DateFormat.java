package BUSINESS.validators;

import BUSINESS.exceptions.InvalidDateException;

public class DateFormat implements Validator {
    private String date;

    public DateFormat(String date) {
        this.date = date;
    }

    @Override
    public boolean validate() throws Exception {
        if(!validFormat()) {
            throw new InvalidDateException();
        }
        return true;
    }

    public boolean validFormat() {
        return true;
    }
}
