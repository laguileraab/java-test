package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {
  
  @Autowired
  private MenuRepository menuRepository;

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      //menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      //Model.menu.addMenu
      menuRepository.save(menu);
      return "The menu is been added to our meals";
    }
    
    @PostMapping("/delMenus")
    public void delMenus() {
      menuRepository.deleteAll();
    }

}
