package customUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeChecker {
    private static final DateTimeFormatter FormatTime = DateTimeFormatter.ofPattern("hh:mm");
    private static final DateTimeFormatter FormatDate = DateTimeFormatter.ofPattern("yy/MM/dd");

    public static String sortDate(LocalDateTime localDateTime) {
        //게시글과 같은 날짜라면 시간만 출력
        if (LocalDate.from(localDateTime).isEqual(LocalDate.now())) {
            return localDateTime.format(FormatTime);
        }
        return localDateTime.format(FormatDate);
    }
}