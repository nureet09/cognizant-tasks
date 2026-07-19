package LoggingDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Instantiate a private static logger associated with this specific class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Logging an error level message
        logger.error("This is an error message");

        // Logging a warning level message
        logger.warn("This is a warning message");
    }
}