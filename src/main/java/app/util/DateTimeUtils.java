package app.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeUtils {

    public static void main(String[] args) {
        String fmt = "FULL";
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.valueOf(fmt));
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(formatter));

        System.out.println(ZonedDateTime.now().getDayOfYear());


    }
}
