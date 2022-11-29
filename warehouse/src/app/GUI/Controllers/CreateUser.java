package app.GUI.Controllers;

import app.LOGGING.ErrorLogging;
import app.BUSINESS.create.InsertUser;
import app.BUSINESS.exceptions.CustomException;
import app.GUI.AlertBox;
import app.LOGGING.ExceptionToString;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateUser {
    @FXML private TextField fullName;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private PasswordField passwordConfirm;
    @FXML private CheckBox adminCheckbox;
    @FXML private Button submitForm;

    public void submitForm() {
        try {
            String fullNameText = fullName.getText();
            String usernameText = username.getText();
            String passwordText = password.getText();
            String passwordConfirmText = passwordConfirm.getText();
            int admin = 1;

            if(adminCheckbox.isSelected()) {
                admin = 2;
            }

            InsertUser.create(fullNameText, usernameText, passwordText, passwordConfirmText, admin);
            fullName.setText("");
            username.setText("");
            password.setText("");
            passwordConfirm.setText("");
            adminCheckbox.setSelected(false);

            AlertBox.display("Съобщение", "Успешно Създаване!");
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }
}
