package my.own.linkaggregator.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${message:test}")
    private String message;

    @GetMapping("")
    public String getMessage(){
        return message;
    }
}
