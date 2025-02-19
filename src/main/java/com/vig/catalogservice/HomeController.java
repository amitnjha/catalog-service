package com.vig.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getGereeting(){
        return "Welcome to Book Catalog from BooksToBorrow";
    }
    
}
