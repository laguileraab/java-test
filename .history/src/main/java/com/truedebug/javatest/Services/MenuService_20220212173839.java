package com.truedebug.javatest.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.truedebug.javatest.Entities.Menu;
    @Service
    public class MenuService
    {
        @Autowired
        MenuRepository menuRepository;
        public List<Menu> getAllStudent()
        {
            List<Menu> menus = new ArrayList<Menu>();
            menuRepository.findAll().forEach(student -> menus.add(student));
            return menus;
        }
        
        public Menu getStudentById(int id)
        {
            return menuRepository.findById(id).get();
        }
        
        public void saveOrUpdate(Menu menu)
        {
            menuRepository.save(menu);
        }
        
        public void delete(int id)
        {
            menuRepository.deleteById(id);
        }
    }