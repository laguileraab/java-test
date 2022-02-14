package com.truedebug.javatest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Error {

    @GetMapping("/error")
    public String listMenu() {
     // model.addAttribute("greeting", );
        return "Are you lost?";
    }
}
