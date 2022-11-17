package LOGGING;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public abstract class Logging {
    private static final Logger logger = LogManager.getLogger(ErrorLogging.class);

    public abstract void log(Marker marker, String msg);

    public static Logger getLogger() {
        return logger;
    }
}