package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      //menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      
      return "The menu is been added to our meals";
    }

}