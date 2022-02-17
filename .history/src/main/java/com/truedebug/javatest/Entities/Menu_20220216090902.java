package com.truedebug.javatest.Entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    
    @Column(name = "OPTIONS", columnDefinition = "json")
    Map<String, String> options = new HashMap<>();

    @Column(name = "DATE")
    Date date;

    public Menu(UUID id, Map<String, String> options, Date date) {
        this.id = id;
        this.options = options;
        this.date = date;
    }

    public Menu(){}

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Map<String,String> getOptions() {
        return this.options;
    }

    public void setOptions(Map<String,String> options) {
        this.options = options;
    }

    public Menu addProperty(String key, String value) {
        options.put(key, value);
        return this;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
