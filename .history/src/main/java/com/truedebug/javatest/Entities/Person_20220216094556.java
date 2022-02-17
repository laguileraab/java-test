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
    @Column(name = "EMAIL")
    String email;
    @Column(name = "NAME")
    String name;
    @Column(name = "PREFERRED MENU")
    String preferredMenu;
    @Column(name = "PASSWORD")
    String password;

    public Person(String email, String password, String name, String preferredMenu) {
        this.name = name;
        this.preferredMenu = preferredMenu;
        this.email=email;
        this.password=password;
    }

    public Person(){}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredMenu() {
        return this.preferredMenu;
    }

    public void setPreferredMenu(String preferredMenu) {
        this.preferredMenu = preferredMenu;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
