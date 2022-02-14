package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {

    @RequestMapping("/")
    public void Run(){
      ArrayList<Menu> menuList = new ArrayList<>();
      Menu menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      menuList.add(menu);
      menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
      menuList.add(menu);
      menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
      menuList.add(menu);
      menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
      menuList.add(menu);
      menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
      menuList.add(menu);
      menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
      menuList.add(menu);
    }

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      //menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      //Model.menu.addMenu
      return "The menu is been added to our meals";
    }

}
