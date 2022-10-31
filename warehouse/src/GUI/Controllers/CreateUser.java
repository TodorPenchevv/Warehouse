package GUI.Controllers;

import BUSINESS.CurrentUser;
import BUSINESS.create.InsertUser;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUser {

    public CreateUser() {
        CurrentUser user = CurrentUser.getInstance();

        //Don't load the form if the user is not admin!!!
        if(user.getUserId() == 1) {

        }
    }

    public TextField fullName;
    public TextField username;
    public PasswordField password;
    public PasswordField passwordConfirm;
    public CheckBox adminCheckbox;
    public Button submitForm;
    public Label invalidData;

    public void submitForm() {
        String fullNameText = fullName.getText();
        String usernameText = username.getText();
        String passwordText = password.getText();
        String passwordConfirmText = passwordConfirm.getText();
        int admin = 2;

        if(adminCheckbox.isSelected())
            admin = 1;

        try {
            InsertUser.create(fullNameText, usernameText, passwordText, admin);
        } catch (Exception e) {
            invalidData.setText(e.getMessage());
        }
    }
}
