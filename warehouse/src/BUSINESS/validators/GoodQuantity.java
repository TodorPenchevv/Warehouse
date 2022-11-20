package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.NegativeNumberException;
import BUSINESS.exceptions.NotEnoughQuantityException;
import BUSINESS.repository.GoodRepository;
import ORM.Good;
import ORM.Partner;

import java.util.List;

public class GoodQuantity implements Validator{
    List<Good> goods;

    public GoodQuantity(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public void validate() throws CustomException {
        for (Good good : this.goods) {
            if(good.getQuantity() <= 0) {
                throw new NegativeNumberException("Количеството");
            }

            List<Good> repGood = GoodRepository.findByGood(good.getGood());
            if(repGood.get(0).getQuantity() < good.getQuantity()) {
                throw new NotEnoughQuantityException(good.getGood(), repGood.get(0).getQuantity());
            }
        }
    }
}
