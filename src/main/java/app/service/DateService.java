package app.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DateService {

    public String now(){
        return ZonedDateTime.now().toString();
    }

    public String now(Optional<FormatStyle> format){
        if (format.isPresent()){
            return formattedDate.apply(format.get());
        }
        return now();
    }

    private Function<FormatStyle,String> formattedDate = (FormatStyle fmt) -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(fmt);
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(formatter);
    };

}
