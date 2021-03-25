package customUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd   hh:mm");

    public static String formTime(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }
}
