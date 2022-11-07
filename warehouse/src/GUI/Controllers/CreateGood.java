package GUI.Controllers;

import BUSINESS.create.InsertGood;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CreateGood {
    @FXML private TextField good;
    @FXML private TextField price;
    @FXML private TextField quantity;
    @FXML private TextField minQuantity;

    public void createButtonClicked(){
        InsertGood.create(good.getText(),
                Integer.parseInt(quantity.getText()),
                Double.parseDouble(price.getText()),
                Integer.parseInt(minQuantity.getText()));
    }

}
