package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.NotEnoughMoneyException;
import BUSINESS.exceptions.RegistryEmptyException;
import BUSINESS.repository.RegisterRepository;
import ORM.Good;
import ORM.Register;

import java.util.List;

public class Balance implements Validator {
    List<Good> goods;

    public Balance(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public void validate() throws CustomException {
        double balance = 0;

        for(Good good : this.goods) {
            balance += good.getQuantity() * good.getPrice();
        }

        Register register = RegisterRepository.getRegister();

        if(register == null) {
            throw new RegistryEmptyException();
        }

        if(register.getBalance() < balance) {
            throw new NotEnoughMoneyException();
        }
    }
}
