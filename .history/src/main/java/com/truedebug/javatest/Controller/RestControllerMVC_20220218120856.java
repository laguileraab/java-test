package com.truedebug.javatest.Controller;

import java.util.UUID;

import com.truedebug.javatest.Entities.Menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.truedebug.javatest.Services.MenuService;

@RestController
public class RestControllerMVC {
    
    MenuService menuService = new MenuService();

    @GetMapping(value = "/menu/{uuid}")
    public Menu menuitem(@PathVariable UUID uuid){
        return menuService.getMenuById(uuid);
    }
}
