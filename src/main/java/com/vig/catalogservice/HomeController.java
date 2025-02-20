package com.vig.catalogservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${polar.greeting}")
    String greeting;

    @GetMapping("/")
    public String getGereeting(){
        return "Welcome to Book Catalog from BooksToBorrow" + greeting;
    }
    
}
