package com.keystore.azure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    String message = "java-keystore-examples-private";

    @GetMapping("/")
    public String index() {
        return message;
    }
}
