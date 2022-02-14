package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entity.Menu;
import com.truedebug.javatest.Repositorio.MenuRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChooseMenuEmployee {

    private MenuRepository menuRepository;

    @GetMapping("/listMenu")
    public ArrayList<Menu> listMenu() {
     // model.addAttribute("greeting", );
        ArrayList<Menu> menuList = (ArrayList<Menu>) menuRepository.findAll();
        if(menuList!=null){
            return menuList;
        }
            return null;
        }
}
