package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.PartnerAlreadyExistsException;
import BUSINESS.repository.PartnerRepository;
import ORM.Partner;

import java.util.List;

public class PartnerName implements Validator {
    private String name;

    public PartnerName(String name) {
        this.name = name;
    }

    public void validate() throws CustomException {
        if(unique()) {
            throw new PartnerAlreadyExistsException();
        }
    }

    private boolean unique() {
        List<Partner> partners = PartnerRepository.findByName(name);
        return !partners.isEmpty();
    }
}
