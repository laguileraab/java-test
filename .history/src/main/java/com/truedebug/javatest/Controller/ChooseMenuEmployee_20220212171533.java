package com.truedebug.javatest.Controller;

import java.util.ArrayList;

import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping("/")
    public ModelAndView listMenu(Model model) {
     // model.addAttribute("greeting", );
        ModelAndView modelAndView = new ModelAndView();
        ArrayList<Menu> menuList = (ArrayList<Menu>) menuRepository.findAll();
        modelAndView.addObject("model",menuList);
        return modelAndView;
    }
}
