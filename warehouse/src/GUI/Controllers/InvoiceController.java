package GUI.Controllers;

import BUSINESS.create.Insert;
import BUSINESS.create.InsertInvoice;
import BUSINESS.create.InsertUser;
import BUSINESS.create.TempGood;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceController {
    Calendar calendar;
    int userID;
    int partnerID;
    int transactionID;
    //nqkak si da se podade tuka informaciqta za vsqka stoka v teq obekti "TempGood" ili po nqkakuv drug nachin
    List<TempGood> goods = new ArrayList<>();


    public void buttonClicked() {
        InsertInvoice.create(calendar, goods, userID, partnerID, transactionID);
    }
}
