package com.truedebug.javatest.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.truedebug.javatest.Entities.Menu;
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
    Person person = new Person();
    Menu menu = new Menu();
    String today = "";

    @RequestMapping(value = "/")
    public String root(Model model) {
        if(!isAutenticated | person == null){
            Person person = new Person();
            //Necesario para renderizar valores de thymeleaf en auth.html
            model.addAttribute(person);
            return "auth.html";
        }else{
            try{
                return "redirect:/list/"+ person.getEmail();
            }catch(Exception e){
                return "auth.html";
            }
        }
    }

    @RequestMapping(value = "/logout")
    public String logOut(Model model){
        isAutenticated = false;
        person = new Person();
        //Necesario para renderizar valores de thymeleaf en auth.html
        model.addAttribute(person);
        return "auth.html";
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

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String checkPerson(@ModelAttribute Person person) {
        return "/register.html";
    }

    @RequestMapping(value = "/person/new", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "register.html";
        }
        personService.saveOrUpdate(person);
        isAutenticated = true;
        return "redirect:/list/" + person.getEmail();
    }

    @RequestMapping("/list/{email}")
    public ModelAndView listMenu(@PathVariable String email){
        ModelAndView model = new ModelAndView();
        List<Menu> menus = menuService.getAllMenus();
        menus.forEach((m)->{
            if(m.getDate().equals(java.time.LocalDate.now())){
                menu = m;
            }
        });
        List<String> options = new ArrayList<String>();
        options.add(menu.getOption1());
        options.add(menu.getOption2());
        options.add(menu.getOption3());
        options.add(menu.getOption4());
        options.add(menu.getOption5());
        model.addObject("menu", menu);
        model.addObject("options", options);
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

    @RequestMapping("/order/{email}/{id}")
    public ModelAndView listMenu(@PathVariable String email, @PathVariable int id, String menu){
        ModelAndView model = new ModelAndView();
        if(!isAutenticated){
            model.setViewName("index.html");
            return model;
        }
        Person person = personService.getPersonById(email);
        person.setPreferredMenu(menu);
        model.addObject("person", person);
        model.addObject("menu", menuService.getAllMenus());
        model.addObject("date", new Day().valueOf(Calendar.DAY_OF_WEEK));
        model.setViewName("index.html");
        return model;
    }

    @RequestMapping("/menu")
    public String addMenu(Model model){
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        if(!isAutenticated){
            return "index.html";
        }if (person!= null && person.getName().equals("Nora")) {
            return "addMenu.html";
        } else {
            return "index.html";
        }
    }

    @RequestMapping(value = "/menu/new", method = RequestMethod.POST)
    public String addMenu(@ModelAttribute Menu menu, BindingResult result,Model model){

        model.addAttribute("person",person);
        model.addAttribute("menus",menuService.getAllMenus());

        if(!isAutenticated){
            return "index.html";
        }if (person!= null && person.getName().equals("Nora")) {
            menuService.saveOrUpdate(menu);
            return "redirect:/list/"+ person.getEmail();
        } else {
            return "index.html";
        }
    }

}