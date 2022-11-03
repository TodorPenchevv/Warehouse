package GUI.Controllers;

import ORM.Good;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateInvoice implements Initializable {
    public TableView<Good> itemsList;
    public TableColumn<Good, String> listGood, listPrice, listQuantity;
    public TextField quantityField;
    public Button addItemBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Take the goods and load them in "itemsList"
        //IDK why this is not setting the items in the table
        itemsList.setItems(getGoods());
    }

    public void addItem() {
        //When the add button is clicked we check
        //If the quantity is valid
        //If the good is not already in the list

        //Then we add the
    }

    public void create() {
        //Getting partner
        //Getting invoice type
        //Getting all items

        //If buying
            //Check if the registry has the money to cover the payment

        try {
            //Passing the data to Insert class to be validated and saved in the DB
        } catch (Exception e) {
            //Show massage for validation error
        }
    }

    public ObservableList<Good> getGoods() {
        //Just sample data !!!
        Good good1 = new Good();
        good1.setGood("banani");
        good1.setPrice(9.99);
        good1.setQuantity(100);
        Good good2 = new Good();
        good2.setGood("qbulki");
        good2.setPrice(19.99);
        good2.setQuantity(200);
        Good good3 = new Good();
        good3.setGood("portokali");
        good3.setPrice(29.99);
        good3.setQuantity(300);

        ObservableList<Good> goods = FXCollections.observableArrayList();
        goods.add(good1);
        goods.add(good2);
        goods.add(good2);

        return goods;
    }
}
