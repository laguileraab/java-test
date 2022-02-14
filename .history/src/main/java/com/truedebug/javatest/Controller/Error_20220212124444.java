package com.truedebug.javatest.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
     // model.addAttribute("greeting", );
        return "Are you lost?";
    }
}
