package app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(value = AppController.class,properties = { "info.app.version=mock-1.0" })
public class AppControllerITTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnVersion() throws Exception {
        this.mockMvc
                .perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mock-1.0")));

    }
}
