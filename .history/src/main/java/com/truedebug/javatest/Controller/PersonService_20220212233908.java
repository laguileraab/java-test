package com.truedebug.javatest.Controller;

import java.util.ArrayList;
import java.util.List;

import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllMenus()
    {
        List<Person> people = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> people.add(person));
        return people;
    }
    
    public Person getPersonById(String name)
    {
        return personRepository.findById(name).get();
    }
    
    public void saveOrUpdate(Person person)
    {
        personRepository.save(person);
    }
    
    public void delete(String name)
    {
        personRepository.deleteById(name);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
