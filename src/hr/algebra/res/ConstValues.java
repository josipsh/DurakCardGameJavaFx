package hr.algebra.res;

import java.time.format.DateTimeFormatter;

public class ConstValues {
    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE;

    public static DateTimeFormatter getDateTimeFormatter() {
        return DATE_TIME_FORMATTER;

    }

    public static String getAppName() {
        return "DurakCardGame";
    }

    // aspect ratio is 1.5
    public static int getCardViewHolderWidth() {
        return 100;
    }

    public static int getCardViewHolderHeight() {
        return 150;
    }

    public static double getPlayerCardsViewerHeight() {
        return getCardViewHolderHeight() + 30;
    }
}
