package com.truedebug.javatest.Entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    
    @Id
    String name;
    //@Column(name = "preferredMenu")
    Long preferredMenu;

    public Person(String name, Long preferredMenu) {
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
