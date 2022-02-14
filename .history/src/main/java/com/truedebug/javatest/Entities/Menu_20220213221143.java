package com.truedebug.javatest.Entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    UUID id;

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
    @Column(name = "DATE");

    public Menu(long uuid, String mainDish, String garrison, String salad, String dessert, String drink) {
        this.mainDish = mainDish;
        this.garrison = garrison;
        this.salad = salad;
        this.dessert = dessert;
        this.drink = drink;
    }

    public Menu(){}

    public UUID getUUID(){
        return this.id;
    }

    public void setUUID(UUID id) {
        this.id=id;
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
}
