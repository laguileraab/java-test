package com.truedebug.javatest.Repositories;

import com.truedebug.javatest.Entities.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Repositorio que extiende de CrudRepositorio y permite realizar las operaciones en la base de datos

@Repository
public interface PersonRepository  extends CrudRepository<Person, String>{}
