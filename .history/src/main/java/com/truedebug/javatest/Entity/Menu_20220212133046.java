package com.truedebug.javatest.Entity;

public class Menu {
    private String mainDish;
    private String garrison;
    private String salad;
    private String dessert;
    private String drink;

    public Menu(String mainDish, String garrison, String salad, String dessert, String drink) {
        this.mainDish = mainDish;
        this.garrison = garrison;
        this.salad = salad;
        this.dessert = dessert;
        this.drink = drink;
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
        return this.mainDish = mainDish;
        this.garrison = garrison;
        this.salad = salad;
        this.dessert = dessert;
        this.drink = drink;;
    }
}
