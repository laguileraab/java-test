package com.truedebug.Utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomError {
    
    @GetMapping("/error-404")
    public String handleError404() {
        return "Are you lost?";
    }
    @GetMapping("/error-500")
    public String handleError500() {
        return "Server problems, dont worry :(";
    }
}
