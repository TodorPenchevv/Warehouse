package app.LOGGING;

import app.GUI.AlertBox;

public class ErrorLogging extends Logging {
    public void log(String msg) {
        getLogger().error(msg);
        AlertBox.display("Грешка", "Възникна неочаквана грешка! Операцията неуспешна!");
    }
}
