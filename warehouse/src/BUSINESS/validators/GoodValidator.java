package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.GoodAlreadyExistsException;
import BUSINESS.repository.GoodRepository;
import ORM.Good;

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
