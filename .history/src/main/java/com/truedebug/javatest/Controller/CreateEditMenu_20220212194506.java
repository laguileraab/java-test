package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;
import com.truedebug.javatest.Services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEditMenu {
  
  @Autowired
  private MenuService menuService;
  
    @PostMapping("/setMenu")
    public String setMenu(@ModelAttribute Menu menu) {
      menuService.saveOrUpdate(menu);
      return "The menu is been added to our meals";
    }

    @PostMapping("/delMenus")
    public void delMenus() {
      menuService.deleteAll();
    }

}
