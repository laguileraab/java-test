package com.truedebug.javatest.Entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.text.html.Option;

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
    
    @Column(name = "OPTION1")
    String option1;
    @Column(name = "OPTION2")
    String option2;
    @Column(name = "OPTION3")
    String option3;
    @Column(name = "OPTION4")
    String option4;
    @Column(name = "OPTION5")
    String option5;

    @Column(name = "DATE")
    Date date;

    public Menu(UUID id, Date date, String option1, String option2, String option3, String option4, String option5) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.date = date;
    }

    public Menu(){}

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(";", "", ""));
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
