package GUI.Controllers;

import LOGGING.ErrorLogging;
import BUSINESS.create.InsertUser;
import BUSINESS.exceptions.CustomException;
import GUI.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class CreateUser {
    private static final Marker createUserMarker = MarkerManager.getMarker("CreateUser");

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
            new ErrorLogging().log(createUserMarker, e.getMessage());
        }
    }
}
