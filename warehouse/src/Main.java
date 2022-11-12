import GUI.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        //JavaFX Setup
        SceneManager loadScene = new SceneManager();
        loadScene.load(primaryStage, "Вход в системата", "views/login.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
