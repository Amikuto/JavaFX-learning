package sample.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final String DATE_PATTERN="yyyy-MM-DD";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String format(LocalDate date){
        if (date == null){
            return null;
        } else {
            return DATE_TIME_FORMATTER.format(date);
        }
    }

    public static LocalDate parse(String dateString){
        try {
            return DATE_TIME_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e){
            return  null;
        }
    }

    public static boolean validDate(String dateString){
        return DateUtil.parse(dateString) != null;
    }
}
