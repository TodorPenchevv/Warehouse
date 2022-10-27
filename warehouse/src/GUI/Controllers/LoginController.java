package GUI.Controllers;

import BUSINESS.create.InsertUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    public TextField username;
    public TextField password;
    public Button button;

    public void loginButtonClicked() {
        System.out.println("In controller...");
        new InsertUser().create("Ivan", username.getText(), password.getText(), 1);
    }
}
