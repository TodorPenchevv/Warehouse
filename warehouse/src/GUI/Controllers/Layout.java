package GUI.Controllers;

import GUI.Branch;
import GUI.ViewManager;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Layout implements Initializable {
    public TreeView<String> treeView;
    public AnchorPane mainPane;

    private ViewManager viewLoader = new ViewManager();

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.treeViewSetup();
        viewLoader.load(mainPane, "views/welcome.fxml");
    }

    private void treeViewSetup() {
        TreeItem<String> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);

        TreeItem<String> create = Branch.create("Създай...", rootItem);
        Branch.create("Оператор или Администратор", create);
        Branch.create("Клиент или Доставчик", create);
        Branch.create("Каса", create);

        TreeItem<String> goods = Branch.create("Стоки", rootItem);
        Branch.create("Нова стока", goods);
        Branch.create("Наличности", goods);
        Branch.create("Наличности", goods);

        TreeItem<String> invoice = Branch.create("Фактури", rootItem);
        Branch.create("Нова фактура", invoice);
        TreeItem<String> invoicesList = Branch.create("Списък с фактури", invoice);
        Branch.create("Разходи", invoice);
        Branch.create("Приходи", invoice);
        Branch.create("Печалби", invoice);

        TreeItem<String> register = Branch.create("Каса", rootItem);
        Branch.create("Движение на наличността", invoice);

        treeView.setShowRoot(false);
        treeView.setRoot(rootItem);
    }

    public void selectItems() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if(item != null)
            viewLoader.load(mainPane, item.getValue());
    }
}
