package app.controller;

import app.service.DateService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.Optional;

@SpringBootTest(classes = DateController.class,properties = { "info.app.version=test-1.0" })
public class DateControllerTest {

    @Autowired
    private DateController dateController;

    @MockBean
    private DateService dateService;

    @Test
    public void shouldReturnDateTime(){
        // given
        String expectedDateTime = ZonedDateTime.now().toString();
        when(dateService.now(Mockito.any())).thenReturn(expectedDateTime);
        // when
        String actualDatetime = dateController.dateAndTime(Optional.empty());
        // then
        assertEquals(expectedDateTime,actualDatetime);
    }
}
