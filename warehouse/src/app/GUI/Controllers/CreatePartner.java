package app.GUI.Controllers;

import app.LOGGING.ErrorLogging;
import app.BUSINESS.create.InsertPartner;
import app.BUSINESS.exceptions.CustomException;
import app.GUI.AlertBox;
import app.LOGGING.ExceptionToString;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreatePartner {
    @FXML private TextField partnerName;
    @FXML private TextField email;
    @FXML private TextField phone;

    public void submitButtonClicked() {
        try {
            String newPartnerName = partnerName.getText();
            String newPhone = phone.getText();
            String newEmail = email.getText();

            InsertPartner.create(newPartnerName, newPhone, newEmail);
            partnerName.setText("");
            email.setText("");
            phone.setText("");
            AlertBox.display("Съобщение", "Успешно създаване!");
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }
}
