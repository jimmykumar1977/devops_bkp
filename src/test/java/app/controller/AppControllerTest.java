package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppController.class,properties = { "info.app.version=test-1.0" })
public class AppControllerTest {

    @Autowired
    private AppController appController;

    @Value("${info.app.version}")
    private String responseFromProp;

    @Test
    public void shouldReturnAppVersion(){
        // given
        String expectedResponse = responseFromProp;
        // when
        String actualResponse =  appController.getVersion();
        // then
        assertEquals(expectedResponse,actualResponse);
    }
}
