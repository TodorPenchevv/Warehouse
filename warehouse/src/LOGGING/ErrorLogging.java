package LOGGING;

import GUI.AlertBox;
import org.apache.logging.log4j.Marker;

public class ErrorLogging extends Logging {
    public void log(String msg) {
        getLogger().error(msg);
        AlertBox.display("Грешка", "Възникна неочаквана грешка! Операцията неуспешна!");
    }
}
