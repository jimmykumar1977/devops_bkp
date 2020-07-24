package app.controller;

import app.service.DateService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class DateController {

    @Autowired
    private DateService  dateService;

    @GetMapping("datetime")
    public Map<String,String> dateAndTime(@RequestParam(name = "format", required = false) Optional<FormatStyle> format) {
        Map<String,String> responseObject = new HashMap<>();
        responseObject.put("datetime",dateService.now(format));
        return responseObject;
    }


}
