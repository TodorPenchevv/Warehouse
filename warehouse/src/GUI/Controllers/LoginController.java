package GUI.Controllers;

import BUSINESS.CurrentUser;
import BUSINESS.create.InsertRole;
import BUSINESS.create.InsertUser;
import BUSINESS.repository.UserRepository;
import ORM.Roles;
import ORM.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class  LoginController {
    public TextField username;
    public PasswordField password;
    public Button button;
    public Label errorMsg;

    public void loginButtonClicked() {


        //Find user by username
        List<User> users = new UserRepository().findByUsername(username.getText());

        if(users.isEmpty()) {
            errorMsg.setVisible(true);
        } else {
            User foundUser = users.get(0);

            if(password.getText().equals(foundUser.getPassword())) {
                CurrentUser.login(foundUser.getId(), foundUser.getRole().getId());
                System.out.println(CurrentUser.getUserId());
                //Enter the app...
            } else {
                errorMsg.setVisible(true);
            }
        }
    }
}
