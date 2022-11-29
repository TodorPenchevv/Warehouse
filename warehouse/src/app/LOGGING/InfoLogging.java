
package app.LOGGING;

public class InfoLogging extends Logging {
    public void log(String msg) {
        getLogger().info(msg);
    }
}
