package GUI.Controllers;

import BUSINESS.create.InsertPartner;
import BUSINESS.create.InsertUser;
import javafx.scene.control.*;

public class CreatePartner {public TextField fullName;
    public TextField partnerName;
    public TextField email;
    public TextField phone;
    public Button submitForm;
    public Label invalidData;

    public void submitForm() {
        invalidData.setVisible(false);
        String partnerNameText = partnerName.getText();
        String phoneText = phone.getText();
        String emailText = email.getText();

        try {
            InsertPartner.create(partnerNameText, phoneText, emailText);
        } catch (Exception e) {
            invalidData.setVisible(true);
            invalidData.setText(e.getMessage());
        }
    }
}
