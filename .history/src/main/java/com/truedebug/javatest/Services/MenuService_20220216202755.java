package com.truedebug.javatest.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.truedebug.javatest.Entities.Menu;
import com.truedebug.javatest.Repositories.MenuRepository;

//Servicio que permite utilizar la clase repositorio para realizar las operaciones con la base de datos
    @Service
    public class MenuService
    {
        @Autowired
        MenuRepository menuRepository;

        public List<Menu> getAllMenus()
        {
            List<Menu> menus = new ArrayList<Menu>();
            menuRepository.findAll().forEach(menu -> menus.add(menu));
            return menus;
        }
        
        public Menu getMenuById(UUID uuid)
        {
            return menuRepository.findById(uuid).get();
        }
        
        public void saveOrUpdate(Menu menu)
        {
            menuRepository.save(menu);
        }
        
        public void delete(UUID id)
        {
            menuRepository.deleteById(id);
        }

        public void deleteAll() {
            menuRepository.deleteAll();
        }
    }