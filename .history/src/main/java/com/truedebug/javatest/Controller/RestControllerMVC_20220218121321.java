package com.truedebug.javatest.Controller;

import java.util.List;
import java.util.UUID;

import com.truedebug.javatest.Entities.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.truedebug.javatest.Services.MenuService;

@RestController
public class RestControllerMVC {
    
    @Autowired
    MenuService menuService = new MenuService();

    @GetMapping(value = "/menu/{uuid}")
    public Menu menuitem(@PathVariable UUID uuid){
        return menuService.getMenuById(uuid);
    }
    
    @GetMapping(value = "/menus}")
    public List<Menu> menus(){
        return menuService.getAllMenus();
    }
}
