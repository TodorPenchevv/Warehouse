package GUI.Controllers;

import BUSINESS.repository.GoodRepository;
import ORM.Good;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class GoodQuery {
    @FXML private Label priceLabel;
    @FXML private Label quantityLabel;
    @FXML private TextField goodField;

    public void submitButtonClicked(){
        List<Good> goods = GoodRepository.findByGood(goodField.getText());
        String price = String.valueOf(goods.get(0).getPrice());
        String quantity = String.valueOf(goods.get(0).getQuantity());

        priceLabel.setText("Цена: "+price);
        quantityLabel.setText("Количество: "+quantity);
    }
}
