package com.keystore.azure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
<<<<<<< HEAD
    String message = "java-keystore-examples-public";
=======
    String message = "java-keystore-examples-private";
>>>>>>> b98f9004a0d79519090e6ef18110b524ef018afa

    @GetMapping("/")
    public String index() {
        return message;
    }
}
