package com.truedebug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import Entity.Menu;
import Entity.MenuList;

@Controller
public class CreateEditMenu {
    @GetMapping("/listMenu")
    public String greetingForm(Model model) {
      model.addAttribute("greeting", new MenuList());
      return MenuList();
    }
}
