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
        menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
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
        return menuList;
    }
}
