package GUI.Controllers;

import BUSINESS.CurrentUser;
import BUSINESS.create.InsertUser;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateUser {
    @FXML private TextField fullName;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private PasswordField passwordConfirm;
    @FXML private CheckBox adminCheckbox;
    @FXML private Button submitForm;
    @FXML private Label errorMsg;
    @FXML private Label successLabel;

    public void submitForm() {
        errorMsg.setText("");
        successLabel.setText("");

        String fullNameText = fullName.getText();
        String usernameText = username.getText();
        String passwordText = password.getText();
        String passwordConfirmText = passwordConfirm.getText();
        int admin = 2;

        if(adminCheckbox.isSelected()) {
            admin = 1;
        }

        try {
            InsertUser.create(fullNameText, usernameText, passwordText, passwordConfirmText, admin);
            fullName.setText("");
            username.setText("");
            password.setText("");
            passwordConfirm.setText("");
            adminCheckbox.setSelected(false);
            successLabel.setText("Успешно Създаване!");
        } catch (Exception e) {
            errorMsg.setText(e.getMessage());
        }
    }
}
