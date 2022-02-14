package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entity.Menu;
import com.truedebug.javatest.Repositorio.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {
  
  @Autowired
  private MenuRepository menuRepository;

   /* @RequestMapping("/")
    public void Run(){
      Menu menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      menuRepository.save(menu);
      menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
      menuRepository.save(menu);
      menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
      menuRepository.save(menu);
      menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
      menuRepository.save(menu);
      menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
      menuRepository.save(menu);
      menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
      menuRepository.save(menu);
    }*/

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
