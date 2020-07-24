package app.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DateService.class)
public class DateServiceTest {

    @Autowired
    private DateService dateService;

    private Function<FormatStyle,String> formattedDate = (FormatStyle fmt) -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(fmt);
        return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(formatter);
    };

    @Test
    public void shouldReturnDateWithNoFormat(){
        // given
        String expectedDateTime = ZonedDateTime.now().toString();
        // when
        String actualDatetime = dateService.now();
        // then
        assertEquals(expectedDateTime,actualDatetime);
    }

    @Test
    public void shouldReturnDateWithFormatFULL(){
        // given
        String expectedDateTime = formattedDate.apply(FormatStyle.FULL);
        // when
        String actualDatetime = dateService.now(Optional.of(FormatStyle.FULL));
        // then
        Assertions.assertThat(actualDatetime).endsWith(expectedDateTime);
    }

    @Test
    public void shouldReturnDateWithFormatSHORT(){
        // given
        String expectedDateTime = formattedDate.apply(FormatStyle.SHORT);
        // when
        String actualDatetime = dateService.now(Optional.of(FormatStyle.SHORT));
        // then
        Assertions.assertThat(actualDatetime).startsWith(expectedDateTime);
    }
}
