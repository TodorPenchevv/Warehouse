package GUI.Controllers;

import LOGGING.ErrorLogging;
import BUSINESS.create.InsertPartner;
import BUSINESS.exceptions.CustomException;
import GUI.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class CreatePartner {
    private static final Marker createPartnerMarker = MarkerManager.getMarker("CreatePartner");
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
            new ErrorLogging().log(createPartnerMarker, e.getMessage());
        }
    }
}
