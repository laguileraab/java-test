package com.truedebug.javatest.Repositorio;

import com.truedebug.javatest.Entity.Menu;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>{}
