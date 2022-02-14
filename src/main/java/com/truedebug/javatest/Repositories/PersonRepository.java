package com.truedebug.javatest.Repositories;

import com.truedebug.javatest.Entities.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends CrudRepository<Person, String>{}
