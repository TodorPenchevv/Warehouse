package GUI.Controllers;

import BUSINESS.create.InsertPartner;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreatePartner {
    @FXML private TextField partnerName;
    @FXML private TextField email;
    @FXML private TextField phone;
    @FXML private Label successLabel;
   // @FXML private Label invalidData;

    public void submitButtonClicked() {
        String newPartnerName = partnerName.getText();
        String newPhone = phone.getText();
        String newEmail = email.getText();

        //validation
        try {
            InsertPartner.create(newPartnerName, newPhone, newEmail);
            partnerName.setText("");
            email.setText("");
            phone.setText("");
            successLabel.setText("Успешно Създаване!");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
