package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
public class DateController {

    @GetMapping("datetime")
    public String dateAndTime(@RequestParam(name = "format", required = false) Optional<FormatStyle> format) {
        if (format.isPresent()) {
            return formattedDate.apply(format.get());
        }
        return ZonedDateTime.now().toString();
    }

    private Function<FormatStyle,String> formattedDate = (FormatStyle fmt) -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(fmt);
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(formatter);
    };
}
