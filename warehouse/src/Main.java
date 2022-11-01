import BUSINESS.GetSession;
import BUSINESS.create.*;
import BUSINESS.repository.GoodRepository;
import BUSINESS.repository.InvoiceRepository;
import BUSINESS.repository.UserRepository;
import ORM.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main{

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        //JavaFX Setup
        Parent root = FXMLLoader.load(getClass().getResource("GUI/views/login.fxml"));
        primaryStage.setTitle("Складова програма");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }*/

    public static void main(String[] args) {
        //launch(args);

        Invoice invoice = new Invoice();
        invoice.getUser().getRole().getRole();

    }
}
