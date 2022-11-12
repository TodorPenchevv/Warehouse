package GUI.Controllers;

import BUSINESS.CurrentUser;
import BUSINESS.create.InsertUser;
import javafx.scene.control.*;

public class CreateUser {
    public TextField fullName;
    public TextField username;
    public PasswordField password;
    public PasswordField passwordConfirm;
    public CheckBox adminCheckbox;
    public Button submitForm;
    public Label invalidData;
    public Label successLabel;

    public void submitForm() {
        invalidData.setVisible(false);

        String fullNameText = fullName.getText();
        String usernameText = username.getText();
        String passwordText = password.getText();
        String passwordConfirmText = passwordConfirm.getText();
        int admin = 2;

        if(adminCheckbox.isSelected())
            admin = 1;

        try {
            InsertUser.create(fullNameText, usernameText, passwordText, admin);
            fullName.setText("");
            username.setText("");
            password.setText("");
            passwordConfirm.setText("");
            adminCheckbox.setSelected(false);
            successLabel.setText("Успешно Създаване!");
        } catch (Exception e) {
            invalidData.setVisible(true);
            invalidData.setText(e.getMessage());
        }
    }
}
