package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entity.Menu;
import com.truedebug.javatest.Repositorio.MenuRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {

  private MenuRepository menuRepository;

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      //menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      //Model.menu.addMenu
      return "The menu is been added to our meals";
    }
    
    @PostMapping("/delMenus")
    public void delMenus() {
      menuRepository.deleteAll();
    }

}
