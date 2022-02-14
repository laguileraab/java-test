package com.truedebug.javatest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Error {

    @GetMapping("/error")
    public String listMenu() {
     // model.addAttribute("greeting", );
        return "Are you lost?";
    }
}
