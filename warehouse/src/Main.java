import BUSINESS.GetSession;
import BUSINESS.create.InsertRole;
import BUSINESS.create.InsertUser;
import ORM.Role;
import ORM.Roles;
import ORM.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        //JavaFX Setup
        Parent root = FXMLLoader.load(getClass().getResource("GUI/views/login.fxml"));
        primaryStage.setTitle("Складова програма");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        /*InsertRole.create(Roles.OPERATOR);
        InsertUser.create("momo","momo","123",1);*/
        launch(args);

    }
}
