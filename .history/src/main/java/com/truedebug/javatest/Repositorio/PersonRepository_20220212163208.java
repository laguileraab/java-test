package com.truedebug.javatest.Repositorio;

import com.truedebug.javatest.Entity.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends CrudRepository<Person, String>{}
