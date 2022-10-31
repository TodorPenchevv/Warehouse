package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

//A class that manages menu loading
//base on the user choice

public class ViewManager {
    //Method loading fxml into AnchorPanes
    public void load(AnchorPane pane, String path) {
        try {
            Parent newFile = FXMLLoader.load(getClass().getResource(path));
            pane.getChildren().setAll(newFile);
        } catch(Exception e) {
            loadFailed(e);
        }
    }

    //If loading error exists it should be logged using log4j
    //for now it is just a console message...
    private void loadFailed(Exception e) {
        System.out.println("Error loading the .fxml file...");
        System.out.println(e.getMessage());
    }

    //Based on the row clicked from the treeView
    //we are loading the corresponding view file (fxml)
    public void chooseView(AnchorPane pane, String option) {
        switch(option) {
            case "Оператор или Администратор":
                this.load(pane, "views/createUser.fxml");
                break;
            case "Клиент или Доставчик":
                this.load(pane, "views/createPartner.fxml");
                break;
            case "Каса":
                this.load(pane, "views/createRegister.fxml");
                break;
            case "Нова стока":
                this.load(pane, "views/createGood.fxml");
                break;
            case "Наличности":
                this.load(pane, "views/listGoods.fxml");
                break;
            case "Нова фактура":
                this.load(pane, "views/createInvoice.fxml");
                break;
            case "Списък с фактури":
                this.load(pane, "views/listInvoices.fxml");
                break;
            case "Разходи":
                this.load(pane, "views/expenses.fxml");
                break;
            case "Приходи":
                this.load(pane, "views/income.fxml");
                break;
            case "Печалби":
                this.load(pane, "views/profit.fxml");
                break;
            case "Движение на наличността":
                this.load(pane, "views/movement.fxml");
                break;
        }
    }
}
