package LOGGING;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionToString {
    public static String convert(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        return sw.toString();
    }
}
