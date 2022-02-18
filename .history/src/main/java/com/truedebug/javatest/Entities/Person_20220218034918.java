package com.truedebug.javatest.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Clase entidad de la base de datos PERSON

@Entity
@Table(name = "PERSON")
public class Person {
    
    @Id
    @Column(name = "EMAIL")
    String email;
    @Column(name = "NAME")
    String name;
    @Column(name = "NATIONALITY")
    String nationality;
    @Column(name = "PREFERREDMENU")
    String preferredMenu;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "DATE")
    Date date;
    @Column(name = "RECOMENDATIONS")
    String recomendations;

    public Person(String email, String password, String name, String nationality, String preferredMenu, Date date,String recomendations) {
        this.name = name;
        this.preferredMenu = preferredMenu;
        this.email=email;
        this.password=password;
        this.date=date;
        this.recomendations=recomendations;
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

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecomendations() {
        return this.recomendations;
    }

    public void setRecomendations(String recomendations) {
        this.recomendations = recomendations;
    }
}
