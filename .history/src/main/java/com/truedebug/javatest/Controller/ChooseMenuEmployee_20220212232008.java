package com.truedebug.javatest.Controller;

import java.util.Calendar;

import com.truedebug.javatest.Services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String root() {

        return "redirect:/list";
    }

    @RequestMapping("/list")
    public ModelAndView listMenu(){
        ModelAndView model = new ModelAndView();
        model.addObject("menus",menuService.getAllMenus());
        model.addObject("date", new Day().valueOf(Calendar.DAY_OF_WEEK));
        model.setViewName("index.html");
        return model;
    }
}