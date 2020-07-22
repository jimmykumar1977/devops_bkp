package app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${info.app.version}")
    private String version;

    @GetMapping(value = "version")
    public String getVersion() {
        return version;
    }
}
