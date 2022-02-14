package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChooseMenuEmployee {
    @GetMapping("/listMenu")
    public ArrayList<Menu> listMenu() {
     // model.addAttribute("greeting", );
        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
        menuList.add(menu);
        return menuList;
    }
}
