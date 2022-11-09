package GUI.Controllers;

import BUSINESS.create.InsertGood;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CreateGood {
    @FXML private TextField good;
    @FXML private TextField price;
    @FXML private TextField quantity;
    @FXML private TextField minQuantity;
    @FXML private Label successLabel;

    public void createButtonClicked(){
        String newGood = good.getText();
        int newQuantity = Integer.parseInt(quantity.getText());
        int newMinQuantity = Integer.parseInt(minQuantity.getText());
        double newPrice = Double.parseDouble(price.getText());

        //validation

        InsertGood.create(newGood, newQuantity, newPrice, newMinQuantity);
        successLabel.setText("Успешно Създаване!");
    }
}
