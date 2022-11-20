
package LOGGING;

import org.apache.logging.log4j.Marker;

public class InfoLogging extends Logging {
    public void log(String msg) {
        getLogger().info(msg);
    }
}
