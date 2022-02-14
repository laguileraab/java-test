package com.truedebug.javatest.Entity;

public class Person {
    private String name;
    private Menu preferredMenu;

    public Person(String name, Menu preferredMenu) {
        this.name = name;
        this.preferredMenu = preferredMenu;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getPreferredMenu() {
        return this.preferredMenu;
    }

    public void setPreferredMenu(Menu preferredMenu) {
        this.preferredMenu = preferredMenu;
    }
}
