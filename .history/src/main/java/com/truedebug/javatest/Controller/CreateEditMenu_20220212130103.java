package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {

    @PostMapping("/setMenu")
    public Menu setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
      menu = new Menu("Cerdo","Congri","Pepino","Helado","Jugo de mango");
      menu = new Menu("Picadillo","Arroz","Papa","Pancake","Jugo de mango");
      menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Jugo de mango");
      menu = new Menu("Jamon","Tallarines","Queso","Pudin","Jugo de mango");
      menu = new Menu("Res","Arroz con frijoles","Machuquillo","Tortica","Vino tinto");
      return menu;
    }

}
