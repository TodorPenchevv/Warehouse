package BUSINESS.validators;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.UsernameTakenException;
import BUSINESS.repository.UserRepository;
import ORM.User;

import java.util.List;

public class Username implements Validator {
    private String username;

    public Username(String username) {
        this.username = username;
    }

    @Override
    public void validate() throws CustomException {
        if(usernameExists()) {
            throw new UsernameTakenException();
        }
    }

    public boolean usernameExists() {
        List<User> users = UserRepository.findByUsername(username);
        return (users != null && !users.isEmpty());
    }
}
