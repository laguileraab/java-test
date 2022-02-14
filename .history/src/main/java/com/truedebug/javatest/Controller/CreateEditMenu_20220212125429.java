package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {

    @PostMapping("/setMenu")
    public Menu setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
      return menu;
    }

}
