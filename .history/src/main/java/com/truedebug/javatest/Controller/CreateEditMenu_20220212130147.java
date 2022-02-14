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
      menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
      menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
      menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
      menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
      menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
      return menu;
    }

}
