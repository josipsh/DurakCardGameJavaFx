package hr.algebra.res;

import java.time.format.DateTimeFormatter;

public class ConstValues {
    private  static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE;

    public static DateTimeFormatter getDateTimeFormatter() {
        return DATE_TIME_FORMATTER;
    }

    public static String getAppName(){
        return "DurakCardGame";
    }
}
