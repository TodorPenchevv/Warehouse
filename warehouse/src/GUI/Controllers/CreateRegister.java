package GUI.Controllers;

import BUSINESS.create.InsertRegister;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//only 1 register
public class CreateRegister {
    @FXML private TextField balance;

    public void createButtonClicked(){
        double newBalance = Double.parseDouble(balance.getText());

        InsertRegister.create(1, newBalance);
    }
}
