package com.truedebug.javatest.Controller;

import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;
import com.truedebug.javatest.Services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChooseMenuEmployee {
    
    @Autowired
    private MenuService menuRepository;

    @RequestMapping("/")
    public ModelAndView listMenu(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if(menuRepository==null){
            Menu menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
            menuRepository.saveOrUpdate(menu);
            menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
            menuRepository.saveOrUpdate(menu);
            menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
            menuRepository.saveOrUpdate(menu);
            menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
            menuRepository.saveOrUpdate(menu);
            menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
            menuRepository.saveOrUpdate(menu);
            menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
            menuRepository.saveOrUpdate(menu);
    }

        modelAndView.addObject("menu",menuRepository.findAll());
        return modelAndView;
    }
}
