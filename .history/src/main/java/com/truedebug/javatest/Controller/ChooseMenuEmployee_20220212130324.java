package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChooseMenuEmployee {
    @GetMapping("/listMenu")
    public ArrayList<Menu> listMenu() {
     // model.addAttribute("greeting", );
        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu = new Menu("Pollo","Arroz","Tomate","Tortica","Jugo de mango");
        menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
        menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
        menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
        menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
        menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
        menuList.add(menu);
        return menuList;
    }
}
