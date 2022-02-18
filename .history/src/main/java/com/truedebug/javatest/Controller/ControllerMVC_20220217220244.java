package com.truedebug.javatest.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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
        if(!isAutenticated | person == null){
            Person person = new Person();
            //Necesario para renderizar valores de thymeleaf en auth.html
            model.addAttribute(person);
            return "auth.html";
        }else{
            try{
                //Si el usuario se encuentra autenticado mostrarle la lista de opciones del menu del día y que escoge la que prefiere
                return "redirect:/list/"+ person.getEmail();
            }catch(Exception e){
                //En caso de que no se encuentre autenticado se le muestra la página para que se autentique
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
            if(person.getPassword().equals(person.getPassword())){
                //Si el correo y el password coinciden se autentifica
                isAutenticated = true;
                return "redirect:/list/" + person.getEmail();
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
    public String createPerson(@ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            //En caso de que los datos ingresados contengan errores
            return "register.html";
        }
        //Se crea la persona correctamente y se almacena a través del servicio
        personService.saveOrUpdate(person);
        isAutenticated = true;
        return "redirect:/list/" + person.getEmail();
    }

    //Listar menú del día
    @RequestMapping("/list/{email}")
    public ModelAndView listMenu(@PathVariable String email){
        ModelAndView model = new ModelAndView();
        //Se extraen los menus a través del servicio
        List<Menu> menus = menuService.getAllMenus();
        //Limpiar el menú del día anterior
        menu = new Menu();
        //Se busca el menú del día
        menus.forEach((m)->{
            //Es necesario parsear la fecha de yyyy-MM-dd HH:MM:ss a yyyy-MM-dd debido a la inserción en la BD
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String storedDate = simpleDateFormat.format(m.getDate());
            LocalDate date = LocalDate.parse(storedDate);
            if(java.time.LocalDate.now().isEqual(date)){
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
        model.addObject("menu", menu);
        //Se envía a la view de index.html para thymeleaf
        model.addObject("options", options);
        if(!isAutenticated){
            //Se establece la vista a mostrar
            model.setViewName("index.html");
            return model;
        }
        Person person = personService.getPersonById(email);
        //Se envían los datos de la persona autenticada para guardar su pedido
        model.addObject("person", person);
        //Se muestra el día de la semana en español
        model.addObject("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

        model.setViewName("index.html");
        return model;
    }

    ///Guardar opcion del menú del día en la base de datos
    @RequestMapping("/order/{email}/{id}/{option}")
    public ModelAndView listMenu(@PathVariable String email, @PathVariable UUID id, @PathVariable String option){
        ModelAndView model = new ModelAndView();
        if(!isAutenticated){
            model.setViewName("index.html");
            return model;
        }
        Person person = personService.getPersonById(email);
        person.setPreferredMenu(option);
        model.addObject("person", person);
        model.addObject("menu", menu);
        model.addObject("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
        personService.saveOrUpdate(person);
        model.setViewName("index.html");
        return model;
    }

    ///Mostrar template para crear un nuevo menu menu.html
    @RequestMapping("/menu")
    public String addMenu(Model model){
        //Limpiar posibles valores anteriores y que no sean mostrados en el formulario
        Menu menu = new Menu();
        //Necesario para enviar objeto menu a la template addMenu.html con thymeleaf
        model.addAttribute("menu", menu);
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

        ///Mostrar template para actualizar menu menu2.html
        @RequestMapping("/menu2")
        public String updateMenu(Model model){

            //Necesario para enviar objeto men a la template menuupdate.html con thymeleaf
            model.addAttribute("person",person);
            model.addAttribute("menu", menu);

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
            return "redirect:/list/"+ person.getEmail();
        } else {
            return "index.html";
        }
    }

        ///Enviar datos para Modificar/Eliminar un menu de la BD
        @RequestMapping(value = "/ges/{uuid}")
        public String gesMenu(Model model, @PathVariable UUID uuid){

            //Necesario para enviar los datos a /menu/ges/{uuid}
            model.addAttribute("person", person);
            
            ///
            if(uuid == null){
                //En caso de no existir ningun menu en el dia para modificar/eliminar se envia al menu de Crear Menu
                model.addAttribute("menu", menu);
                return "menu.html";
            }else{
                //Necesario para enviar los datos a /menu/ges/{uuid}
                menu = menuService.getMenuById(uuid);
                model.addAttribute("menu", menu);
            }
            if(!isAutenticated){
                return "index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                //Se muestra el día de la semana en español
                model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
                return "menuupdate.html";
            } else {
                return "index.html";
            }
        }
        ///Enviar datos para Eliminar un menu de la BD
        @RequestMapping(value = "/delm/{uuid}")
        public String delMenu(@ModelAttribute Menu menu, Model model,@PathVariable UUID uuid){

            //Necesario para enviar los datos a /listEmployees
            model.addAttribute("person",person);
            model.addAttribute("persons", personService.getAllPersons());
            //

            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

            ///
            if(!isAutenticated){
                return "index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                menuService.delete(uuid);
                return "employees.html";
            } else {
                return "index.html";
            }
        }

        ///Listar pedidos de los empleados
        @RequestMapping(value = "/employees")
        public String listEmployees(@ModelAttribute Menu menu, BindingResult result,Model model){
    
            //Necesario para enviar los datos a /listEmployees
            model.addAttribute("persons", personService.getAllPersons());
            //Se muestra el día de la semana en español
            model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));

            model.addAttribute("person", person);

            if(!isAutenticated){
                return "index.html";
            }
            if (person!= null && person.getName().equals("Nora")) {
                return "employees.html";
            } else {
                return "index.html";
            }
        }
                ///Enviar datos para Eliminar un menu de la BD
                @RequestMapping(value = "/delm/{uuid}")
                public String delMenu(@ModelAttribute Menu menu, Model model,@PathVariable UUID uuid){
        
                    //Necesario para enviar los datos a /listEmployees
                    model.addAttribute("person",person);
                    model.addAttribute("persons", personService.getAllPersons());
                    //
        
                    //Se muestra el día de la semana en español
                    model.addAttribute("today", new Day().valueOf(Calendar.DAY_OF_WEEK));
        
                    ///
                    if(!isAutenticated){
                        return "index.html";
                    }
                    if (person!= null && person.getName().equals("Nora")) {
                        menuService.delete(uuid);
                        return "employees.html";
                    } else {
                        return "index.html";
                    }
                }
}