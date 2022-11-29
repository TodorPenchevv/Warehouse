package app.GUI.Controllers;

import app.BUSINESS.create.InsertRegister;
import app.BUSINESS.exceptions.CustomException;
import app.GUI.AlertBox;
import app.LOGGING.ErrorLogging;
import app.LOGGING.ExceptionToString;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//only 1 register
public class CreateRegister {
    @FXML private TextField balance;

    public void createButtonClicked(){
        try {
            double newBalance = Double.parseDouble(balance.getText());

            InsertRegister.create(1, newBalance);
            AlertBox.display("Съобщение", "Успешно създаване!");
        } catch (CustomException e) {
            AlertBox.display("Грешка", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }
}
