package Logger_2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Logger {
    static protected int counter = 1;
    private static Logger logger = null;

    private Logger() {}

    public void log(String msg) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");
        System.out.println("\t[" + LocalDateTime.now().format(formatter) + " " +
                counter++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}