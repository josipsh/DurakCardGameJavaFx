package hr.algebra.utils.logger;

public class Logger {
    private static final LoggerImpl logger = new LoggerImpl();

    public static void log(String message, Throwable exception) {
        logger.logSevere(message, exception);
    }
}
