package GUI.Controllers;

import BUSINESS.GetSession;
import LOGGING.ErrorLogging;
import LOGGING.ExceptionToString;
import ORM.Register;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentBalance implements Initializable {
   @FXML private Label balance;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      try {
         double currentBalance = GetSession.getSession().get(Register.class, 1).getBalance();
         balance.setText(String.valueOf(currentBalance));
      } catch (Exception e) {
         new ErrorLogging().log(ExceptionToString.convert(e));
      }
   }
}
