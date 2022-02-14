package com.truedebug.javatest.Controller;

import java.util.Calendar;

import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuService menuService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/")
    public ModelAndView root() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Auth.html");
        return modelAndView;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String createPerson(Person person, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "person/new";
        }
        personService.saveOrUpdate(person);
        redirectAttrs.addAttribute("name", person.getName()).addFlashAttribute("message", "Cuenta correcta!");
        return "redirect:/list/{name}";
    }

    @RequestMapping("/list/{name}")
    public ModelAndView listMenu(@PathVariable String name){
        ModelAndView model = new ModelAndView();
        Person person = personService.getPersonById(name);
        model.addObject("person", person);
        model.addObject("menus", menuService.getAllMenus());
        model.addObject("date", new Day().valueOf(Calendar.DAY_OF_WEEK));
        model.setViewName("index.html");
        return model;
    }
}