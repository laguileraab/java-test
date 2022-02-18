package com.truedebug.javatest.Controller;

@RestController
public class RestControllerMVC {
    
    @GetMapping(value = "/menu/{uuid}")
    public Menu menuitem(@PathVariable UUID uuid){
        return menuService.getMenuById(uuid);
    }
}
