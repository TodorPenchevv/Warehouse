package GUI.Controllers;

import LOGGING.ErrorLogging;
import BUSINESS.create.InsertGood;
import BUSINESS.exceptions.CustomException;
import GUI.AlertBox;
import LOGGING.ExceptionToString;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateGood {
    @FXML private TextField good;
    @FXML private TextField price;
    @FXML private TextField quantity;
    @FXML private TextField minQuantity;

    public void createButtonClicked() {
        try {
            String newGood = good.getText();
            int newQuantity = Integer.parseInt(quantity.getText());
            int newMinQuantity = Integer.parseInt(minQuantity.getText());
            double newPrice = Double.parseDouble(price.getText());

            InsertGood.create(newGood, newQuantity, newPrice, newMinQuantity);
            good.setText("");
            quantity.setText("");
            minQuantity.setText("");
            price.setText("");
            AlertBox.display("Съобщение", "Успешно създаване!");
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }
}
