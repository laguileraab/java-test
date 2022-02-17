package com.truedebug.javatest.Services;

import java.util.ArrayList;
import java.util.List;

import com.truedebug.javatest.Entities.Person;
import com.truedebug.javatest.Repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio que permite utilizar la clase repositorio para realizar las operaciones con la base de datos
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons()
    {
        List<Person> people = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> people.add(person));
        return people;
    }
    
    public Person getPersonById(String email)
    {
        return personRepository.findById(email).get();
    }
    
    public void saveOrUpdate(Person person)
    {
        personRepository.save(person);
    }
    
    public void delete(String email)
    {
        personRepository.deleteById(email);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
}
