package com.truedebug.javatest.Entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
    
    @Id
    String name;
    @Column(name = "PREFERREDMENU")
    Long preferredMenu;

    public Person(String name, Long preferredMenu) {
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

    public Long getPreferredMenu() {
        return this.preferredMenu;
    }

    public void setPreferredMenu(Long preferredMenu) {
        this.preferredMenu = preferredMenu;
    }
}
