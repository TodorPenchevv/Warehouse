package GUI.Controllers;

import BUSINESS.exceptions.CustomException;
import BUSINESS.exceptions.GoodNotFoundException;
import BUSINESS.repository.GoodRepository;
import GUI.AlertBox;
import LOGGING.ErrorLogging;
import LOGGING.ExceptionToString;
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
        try {
            String goodName = goodField.getText();
            List<Good> goods = GoodRepository.findByGood(goodName);

            if(goods == null || goods.isEmpty())
                throw new GoodNotFoundException(goodName);

            String price = String.valueOf(goods.get(0).getPrice());
            String quantity = String.valueOf(goods.get(0).getQuantity());

            priceLabel.setText("Цена: " + price+"лв.");
            quantityLabel.setText("Количество: " + quantity);
        } catch (CustomException e) {
            AlertBox.display("Грешни данни", e.getMessage());
        } catch (Exception e) {
            new ErrorLogging().log(ExceptionToString.convert(e));
        }
    }
}
