package com.truedebug.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;

import Entity.Menu;

public class ChooseMenuEmployee {
    @GetMapping("/listMenu")
    public ArrayList<Menu> listMenu() {
     // model.addAttribute("greeting", );
        ArrayList<Menu> menuList = new ArrayList<>();
        return menuList;
    }
}
