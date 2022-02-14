package com.truedebug.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Entity.Menu;
import Entity.MenuList;

@Controller
public class CreateEditMenu {
    @GetMapping("/listMenu")
    public ArrayList<Menu> listMenu() {
     // model.addAttribute("greeting", );
        ArrayList<Menu> menuList = new ArrayList<>();
        return menuList;
    }

    @PostMapping("/setMenu")
    public String setMenu(Menu menu) {
      //model.addAttribute("greeting", menu);
      menu = new Menu("","","","","");
      return menu.toString();
    }

}
