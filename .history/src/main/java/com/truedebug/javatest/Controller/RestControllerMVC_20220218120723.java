package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entities.Menu;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerMVC {
    
    @GetMapping(value = "/menu/{uuid}")
    public Menu menuitem(@PathVariable UUID uuid){
        return menuService.getMenuById(uuid);
    }
}
