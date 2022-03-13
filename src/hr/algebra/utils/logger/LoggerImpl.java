package hr.algebra.utils.logger;

import hr.algebra.res.ConstValues;
import hr.algebra.utils.file.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class LoggerImpl {
    private final DateTimeFormatter DATE_TIME_FORMATTER;

    private final Logger logger;
    private final String logsDirectoryFolder = FileUtils.getLogDir() + File.separator;

    public LoggerImpl() {
        DATE_TIME_FORMATTER = ConstValues.getDateTimeFormatter();
        logger = Logger.getAnonymousLogger();
        configure();
    }

    private void configure() {
        try {
            FileUtils.createDirHierarchy(logsDirectoryFolder);
            FileHandler fileHandler = new FileHandler(
                    logsDirectoryFolder
                            + LocalDateTime.now().format(DATE_TIME_FORMATTER)
                            + ".log", true
            );

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            logger.addHandler(fileHandler);

        } catch (IOException ex) {
            ex.printStackTrace();
            logger.log(Level.OFF, ex.getMessage(), ex);
        }
    }

    private String getCurrentDateString() {
        LocalDateTime date = LocalDateTime.now();
        return date.format(DATE_TIME_FORMATTER);
    }

    public void logSevere(String message, Throwable exception) {
        logger.log(Level.SEVERE, message, exception);
    }
}
