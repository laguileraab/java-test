package com.truedebug.javatest.Entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

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
    
    public Menu(long id, String mainDish, String garrison, String salad, String dessert, String drink) {
        this.mainDish = mainDish;
        this.garrison = garrison;
        this.salad = salad;
        this.dessert = dessert;
        this.drink = drink;
    }

    public Menu(){}

    public Long getId() {
        return this.id;
    }

    public void setMainDish(Long id) {
        this.id = id;
    }

    public String getMainDish() {
        return this.mainDish;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getGarrison() {
        return this.garrison;
    }

    public void setGarrison(String garrison) {
        this.garrison = garrison;
    }

    public String getSalad() {
        return this.salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getDessert() {
        return this.dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return this.drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getMenu() {
        return this.mainDish + this.garrison + this.salad + this.dessert + this.drink;
    }

    public UUID getUUID(UUID uuid){
        this.uuid=uuid;
    }

    public void setUUID(UUID randomUUID) {
    }
}
