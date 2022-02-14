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
    private MenuService menuService;

    @RequestMapping("/")
    public ModelAndView listMenu(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        /*
        if(menuService==null){
            Menu menu = new Menu("Pollo","Arroz","Boniato","Flan","Jugo de mango");
            menuService.saveOrUpdate(menu);
            menu = new Menu("Cerdo","Congri","Pepino","Helado","Granizado");
            menuService.saveOrUpdate(menu);
            menu = new Menu("Picadillo","Arroz","Papa","Pancake","Coca cola");
            menuService.saveOrUpdate(menu);
            menu = new Menu("Perro","Spaghetti","Queso","Dulce de leche","Vodka");
            menuService.saveOrUpdate(menu);
            menu = new Menu("Jamon","Tallarines","Queso","Pudin","Pepsi");
            menuService.saveOrUpdate(menu);
            menu = new Menu("Res","Arroz con frijoles","Machuquillo","Boniatillo","Vino tinto");
            menuService.saveOrUpdate(menu);
    }*/

        modelAndView.addObject("menus",menuService.getAllMenus());
        return modelAndView;
    }
}
