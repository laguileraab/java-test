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
    @Column(name = "PREFERREDMENU")
    int preferredMenu;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "MAINDISH")
    String mainDish;
    @Column(name = "GARRISON")
    String garrison;
    @Column(name = "SALAD")
    String salad;
    @Column(name = "DESSERT")
    String dessert;
    @Column(name = "DRINK")
    String drink;

    public Person(String email, String password, String name, int preferredMenu) {
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

    public int getPreferredMenu() {
        return this.preferredMenu;
    }

    public void setPreferredMenu(int preferredMenu) {
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

    public void setMenu(Menu menu) {

    }
}
