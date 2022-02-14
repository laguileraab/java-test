package com.truedebug.javatest.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Person {
    
    @Id
    private String name;
    @Column(name = "preferredMenu")
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
