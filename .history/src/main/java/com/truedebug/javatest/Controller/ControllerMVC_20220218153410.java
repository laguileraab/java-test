package com.truedebug.javatest.Controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.truedebug.Utils.Convert;
import com.truedebug.Utils.Day;
import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Services.MenuService;
import com.truedebug.javatest.Services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerMVC {
    
    //Inyección de dependencias
    @Autowired
    private MenuService menuService;

    @Autowired
    private PersonService personService;

    //Declarar variables necesarias
    boolean isAutenticated = false;
    Person person = new Person();
    Menu menu = new Menu();
    
    //Raíz
    @RequestMapping(value = "/")
    public String root(Model model) {
        if(!isAutenticated | person == null | person.getEmail() == null | person.getName() == null){
            
            //Necesario para renderizar valores de thymeleaf en auth.html
            Person person = new Person();
            model.addAttribute(person);

            return "auth.html";
        }else{
            try{
                //Si el usuario se encuentra autenticado mostrarle la lista de opciones del menu del día
                return "redirect:/list";
            }catch(Exception e){
                //Muestra la página para que se autentique
                return "auth.html";
            }
        }
    }

    //Cerrar cesión
    @RequestMapping(value = "/logout")
    public String logOut(Model model){
        //Se eliminan valores anteriores
        isAutenticated = false;
        person = new Person();
        //
        //Necesario para renderizar valores de thymeleaf en auth.html
        model.addAttribute(person);

        //Al cerrar la cesión se le muestra la página de autenticación
        return "auth.html";
    }
    
    ///Obtener datos del POST para autenticar a la persona
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String checkPerson(@ModelAttribute Person personAux, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "register.html";
        }
        try{
            //Se buca a la persona en la base de datos a través del correo
            person  = personService.getPersonById(personAux.getEmail());
            if(person.getPassword().equals(personAux.getPassword())){
                //Si el correo y el password coinciden se autentica
                isAutenticated = true;
                return "redirect:/list";
            }else{
                return "auth.html";
            }
        }
        catch(Exception e){
            return "register.html";
        }
    }

    ///Mostrar template para registrar una nueva persona register.html
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String checkPerson(@ModelAttribute Person person) {

        //Se mapea /person para el template register.html
        return "register.html";
    }

    ///Enviar datos del POST para registrar una nueva persona a la BD
    @RequestMapping(value = "/person/new", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute Person personStored, BindingResult result) {

        if (result.hasErrors()) {
            //En caso de que los datos ingresados contengan errores
            return "register.html";
        }
        //Se crea la persona correctamente y se almacena a través del servicio
        personService.saveOrUpdate(personStored);
        isAutenticated = true;
        person = personStored;

        return "redirect:/list";
    }

    //Listar menú del día
    @RequestMapping("/list")
    public String listMenu(Model model){

        //ModelAndView model = new ModelAndView();

        //Se muestra el día de la semana en español
        model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
        
        //Comprobar que el usuario halla realizado el pedido de hoy
        if(person.getDate() != null){

            //Convertir fecha para comparar
            LocalDate dateP = Convert.convertDate(person.getDate());

            if(!java.time.LocalDate.now().isEqual(dateP)){

                //Eliminar pedido anterior a hoy
                person.setDate(null);
                person.setPreferredMenu(null);
            }
        }
        //Necesario para thymeleaf index.html
        model.addAttribute("person", person);
        
        //Necesario para enviar los datos a /listEmployees
        model.addAttribute("persons", personService.getAllPersons());

        if(!isAutenticated){
            //model.setViewName("index.html");
            return "auth.html";
        }

        //Se extraen los menus a través del servicio
        List<Menu> menus = menuService.getAllMenus();

        //Limpiar el menú del día anterior
        menu = new Menu();

        //Se busca el menú del día
        menus.forEach((m)->{
            //Es necesario parsear la fecha de yyyy-MM-dd HH:MM:ss a yyyy-MM-dd debido a la inserción en la BD
            LocalDate dateM = Convert.convertDate(m.getDate());
            if(java.time.LocalDate.now().isEqual(dateM)){
                menu = m;
            }
        });

        //Se extraen todas las opciones del día para pasarlo a thymeleaf como un solo objeto List
        List<String> options = new ArrayList<String>();
        options.add(menu.getOption1());
        options.add(menu.getOption2());
        options.add(menu.getOption3());
        options.add(menu.getOption4());
        options.add(menu.getOption5());

        //Se envían los datos del menú para extraer el ID para Ordenar, Modificar y Eliminar
        model.addAttribute("menu", menu);

        //Se envía a la view de index.html para thymeleaf
        model.addAttribute("options", options);

        //Se muestra el día de la semana en español
        model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

        //model.setViewName("index.html");
        return "index.html";
    }

    ///Guardar opcion del menú del día en la base de datos
    @RequestMapping(value = "/order/{option}")
    public String listMenu(@RequestParam(value="recomendations",required=false) String recomendations, @PathVariable int option, Model model){
        //ModelAndView model = new ModelAndView();
        if(!isAutenticated){
            //model.setViewName("index.html");
            //return model;
            return "index.html";
        }
        switch(option){
            case 0:
            person.setPreferredMenu(menu.getOption1());
            break;
            case 1:
            person.setPreferredMenu(menu.getOption2());
            break;
            case 2:
            person.setPreferredMenu(menu.getOption3());
            break;
            case 3:
            person.setPreferredMenu(menu.getOption4());
            break;
            case 4:
            person.setPreferredMenu(menu.getOption5());
            break;
            default:
            break;
        };
        person.setRecomendations(recomendations);
        model.addAttribute("person", person);
        //Se extraen todas las opciones del día para pasarlo a thymeleaf como un solo objeto List
        List<String> options = new ArrayList<String>();
        options.add(menu.getOption1());
        options.add(menu.getOption2());
        options.add(menu.getOption3());
        options.add(menu.getOption4());
        options.add(menu.getOption5());

        //Se envían los datos del menú para extraer el ID para Ordenar, Modificar y Eliminar
        model.addAttribute("menu", menu);
        model.addAttribute("options", options);
        model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
        person.setDate(Date.from(Instant.now()));
        personService.saveOrUpdate(person);
        //model.setViewName("index.html");
        return "index.html";
        //return model;
    }

    ///Mostrar template para crear un nuevo menu menu.html
    @RequestMapping("/menu")
    public String addMenu(Model model){
        //Limpiar posibles valores anteriores y que no sean mostrados en el formulario
        Menu menu = new Menu();
        //Necesario para enviar objeto menu a la template menu.html con thymeleaf
        model.addAttribute("menu", menu);
        model.addAttribute("person", person);

        if(!isAutenticated){
            return "index.html";
        }
        //Solo Nora está autorizada a crear menús
        if (person!= null && person.getName().equals("Nora")) {
            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
            return "menu.html";
        } else {
            return "index.html";
        }
    }

    ///Enviar datos del POST para crear un nuevo menu a la BD
    @RequestMapping(value = "/menu/new", method = RequestMethod.POST)
    public String gesMenu(Model model, @ModelAttribute Menu menu){

        //Necesario para enviar los datos a /list/{email}
        model.addAttribute("person",person);
        ///

        if(!isAutenticated){
            return "index.html";
        }
        if (person!= null && person.getName().equals("Nora")) {
            //Guardar menú
            if(menu!=null && menu.getId() != null){
                menuService.delete(menu.getId());
            }
            menuService.saveOrUpdate(menu);
            return "redirect:/list";
        } else {
            return "index.html";
        }
    }

        //Listar menú del día
        @RequestMapping("/list/menus")
        public String listMenus(Model model){
            //Se envían los datos del menú para extraer el ID para Ordenar, Modificar y Eliminar
            model.addAttribute("menus", menuService.getAllMenus());

            if(!isAutenticated){
                //Se establece la vista a mostrar
                return "index.html";
            }
            //Se envían los datos de la persona autenticada para guardar su pedido
            model.addAttribute("person", person);
            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
            return "menulist.html";
        }

        ///Enviar datos para Modificar/Eliminar un menu de la BD
        @RequestMapping(value = "/ges/{uuid}")
        public String gesMenu(@ModelAttribute Menu menuaux, Model model, @PathVariable UUID uuid){
            //Necesario para enviar los datos a /ges/{uuid}
            model.addAttribute("person", person);

            if(!isAutenticated){
                return "index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                //Se muestra el día de la semana en español
                model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

                model.addAttribute("menu", menuService.getMenuById(uuid));

                return "menuupdate.html";
            } else {
                return "index.html";
            }
        }
        ///Enviar datos para Eliminar un menu de la BD
        @RequestMapping(value = "/delm/{uuid}")
        public String delMenu(Model model,@PathVariable UUID uuid){

            //Necesario para enviar los datos a /listEmployees
            model.addAttribute("person",person);
            model.addAttribute("persons", personService.getAllPersons());
            //

            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

            ///
            if(!isAutenticated){
                return "/index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                menuService.delete(uuid);
                //Enviamos los menus ordenados segun la fecha
                model.addAttribute("menus",
                menuService.getAllMenus().stream().sorted(Comparator.comparing(Menu::getDate).reversed()).collect(Collectors.toList()));
                return "menulist.html";
            } else {
                return "index.html";
            }
        }

        ///Listar pedidos de los empleados
        @RequestMapping(value = "/employees")
        public String listEmployees(Model model){

            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

            model.addAttribute("person", person);
            
            if(!isAutenticated){
                return "index.html";
            }

            //Modificamos el resultado del menú para mostrar además la recomendación
            List<Person> persons = new ArrayList<Person>();
            personService.getAllPersons().forEach((p)->{
                //Mostramos la opción seleccionada junto a la recomendación
                if(p.getPreferredMenu() != null && p.getPreferredMenu() != ""
                && p.getRecomendations() != null && p.getRecomendations() != ""){
                    p.setPreferredMenu(p.getPreferredMenu() + ", Recomendación: " + p.getRecomendations());
                }
                persons.add(p);
            });

            //Necesario para enviar los datos a /listEmployees
            model.addAttribute("persons", persons);

            if (person!= null && person.getName().equals("Nora")) {
                return "employees.html";
            } else {
                return "index.html";
            }
        }
        ///Enviar datos para Eliminar un menu de la BD
        @RequestMapping(value = "/dele/{email}")
        public String delMenu(Model model,@PathVariable String email){
            //Necesario para enviar los datos a /listEmployees
            model.addAttribute("person",person);
            //
            //Necesario para enviar los datos a /Editar eliminar menu
            model.addAttribute("menu",menu);
            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
            ///
            if(!isAutenticated){
                return "index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                personService.delete(email);
                //Necesario para enviar los datos a /listEmployees
                model.addAttribute("persons", personService.getAllPersons());
                return "employees.html";
            } else {
                return "index.html";
            }
        }
}