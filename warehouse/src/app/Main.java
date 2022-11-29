package app;

import app.BUSINESS.InitializeData;
import app.GUI.SceneManager;
import app.LOGGING.InfoLogging;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Main extends Application{
    private static final Marker mainMarker = MarkerManager.getMarker("java.Main");

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Initialize DB
        new InitializeData();

        //Log4j
        new InfoLogging().log("Starting the application...");

        //JavaFX Setup
        SceneManager loadScene = new SceneManager();
        loadScene.load(primaryStage, "Вход в системата", "views/login.fxml");


        new InitializeData();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
