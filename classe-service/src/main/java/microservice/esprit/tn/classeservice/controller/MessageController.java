package microservice.esprit.tn.classeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/users/message")
    public String message(){
        return message;
    }
}
