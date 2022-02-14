package com.truedebug.javatest.Controller;

import java.util.Calendar;

import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String root(Person person, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "accounts/new";
        }
        // Save account ...
        redirectAttrs.addAttribute("id", person.getName()).addFlashAttribute("message", "Account created!");
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