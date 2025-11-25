package loggingframework;

public class LoggingExample {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Default logging (Console, INFO)
        System.out.println("--- Default Configuration (Console, INFO) ---");
        logger.info("This is an info message");
        logger.debug("This debug message won't be shown");

        // Change configuration to FileAppender and DEBUG level
        System.out.println("\n--- Changing Configuration to FileAppender and DEBUG level ---");
        logger.setConfig(new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log")));
        logger.debug("This debug message will be logged to file");
        logger.error("This error message will be logged to file");
        System.out.println("Check app.log for messages.");

        // Reset to Console for demonstration
        System.out.println("\n--- Back to Console ---");
        logger.setConfig(new LoggerConfig(LogLevel.INFO, new ConsoleAppender()));
        logger.info("Back to console logging");
    }
}
