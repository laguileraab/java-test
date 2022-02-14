package com.truedebug.javatest.Repositorio;

import com.truedebug.javatest.Entity.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, String>{}
