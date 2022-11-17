
package LOGGING;

import org.apache.logging.log4j.Marker;

public class InfoLogging extends Logging {
    public void log(Marker marker, String msg) {
        getLogger().info(marker, msg);
    }
}
