package app.BUSINESS.validators;

import app.BUSINESS.exceptions.CustomException;
import app.BUSINESS.exceptions.NotEnoughMoneyException;
import app.BUSINESS.exceptions.RegistryEmptyException;
import app.BUSINESS.repository.RegisterRepository;
import app.ORM.Good;
import app.ORM.Register;

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
