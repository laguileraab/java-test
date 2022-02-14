package com.truedebug.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Error {
    
    @GetMapping("/error")
    public String listMenu() {
     // model.addAttribute("greeting", );
        return "Are you lost?";
    }
}
