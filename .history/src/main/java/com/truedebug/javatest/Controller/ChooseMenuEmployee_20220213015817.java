package com.truedebug.javatest.Controller;

import java.util.Calendar;

import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Services.MenuService;
import com.truedebug.javatest.Services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    boolean isAutenticated = false;
    Person person;

    @RequestMapping(value = "/")
    public ModelAndView root(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        //Necesario para renderizar valores de thymeleaf en auth.html
        model.addAttribute(new Person());

        if(!isAutenticated){
            modelAndView.setViewName("auth.html");
        }else{
            try{
                modelAndView.setViewName("/list/"+ person.getEmail());
            }catch(Exception e){
                modelAndView.setViewName("auth.html");
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String checkPerson(@ModelAttribute Person personAux, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "/register.html";
        }
        try{
            person  = personService.getPersonById(personAux.getEmail());
            if(person.getPassword().equals(person.getPassword())){
                redirectAttrs.addAttribute("name", person.getName()).addFlashAttribute("message", "Cuenta correcta!");
                isAutenticated = true;
                return "redirect:/list/" + person.getEmail();
            }
        }
        catch(Exception e){
            return "/register.html";
        }
        return "/register.html";
    }

    @RequestMapping(value = "/person/new")
    public String createPerson(@ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/";
        }
        personService.saveOrUpdate(person);
        isAutenticated = true;
        return "redirect:/list/" + person.getEmail();
    }
    
    @RequestMapping("/list/{email}")
    public ModelAndView listMenu(@PathVariable String email){
        ModelAndView model = new ModelAndView();
        if(!isAutenticated){
            model.setViewName("index.html");
            return model;
        }
        Person person = personService.getPersonById(email);
        model.addObject("person", person);
        model.addObject("menus", menuService.getAllMenus());
        model.addObject("date", new Day().valueOf(Calendar.DAY_OF_WEEK));
        model.setViewName("index.html");
        return model;
    }
}