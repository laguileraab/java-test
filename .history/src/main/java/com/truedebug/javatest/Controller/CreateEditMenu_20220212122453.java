package com.truedebug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import Entity.Menu;

@Controller
public class CreateEditMenu {

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      return menu.toString();
    }

}
