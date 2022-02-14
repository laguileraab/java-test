package com.truedebug.javatest.Entities;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
    
    @Id
    @Column(name = "email")
    String email;
    @Column(name = "name")
    String name;
    
    @Column(name = "PREFERREDMENU")
    int preferredMenu;
   

    @Column(name = "password")
    String password;

    public Person(String name, int preferredMenu, String email, String password) {
        this.name = name;
        this.preferredMenu = preferredMenu;
    }

    public Person(){}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreferredMenu() {
        return this.preferredMenu;
    }

    public void setPreferredMenu(Long preferredMenu) {
        this.preferredMenu = preferredMenu;
    }
}
