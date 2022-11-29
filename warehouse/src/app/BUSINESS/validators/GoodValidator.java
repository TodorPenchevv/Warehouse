package app.BUSINESS.validators;

import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.exceptions.GoodAlreadyExistsException;
import app.BUSINESS.repository.GoodRepository;
import app.ORM.Good;

import java.util.List;

public class GoodValidator implements Validator {
    private String good;

    public GoodValidator(String good) {
        this.good = good;
    }

    public void validate() throws CustomException {
        if(goodExists()) {
            throw new GoodAlreadyExistsException(this.good);
        }
    }

    private boolean goodExists() {
        List<Good> goods = GoodRepository.findByGood(good);
        return (goods != null && !goods.isEmpty());
    }
}
