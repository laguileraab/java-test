package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/")
    public ModelAndView listMenu() {
     // model.addAttribute("greeting", );
        ModelAndView modelAndView = new ModelAndView();
        ArrayList<Menu> menuList = (ArrayList<Menu>) menuRepository.findAll();
        modelAndView.addObject("model",menuList);
        return modelAndView;
    }
}
