package com.truedebug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Entity.Menu;
import Entity.MenuList;

@Controller
public class CreateEditMenu {
    @GetMapping("/listMenu")
    public String greetingForm(Model model) {
      model.addAttribute("greeting", new MenuList(null));
      return MenuList();
    }

    @PostMapping("/setMenu")
    public String greetingSubmit(@ModelAttribute Menu menu, Model model) {
      model.addAttribute("greeting", menu);
      return "result";
    }

}
