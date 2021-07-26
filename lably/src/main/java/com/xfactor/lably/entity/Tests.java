package com.xfactor.lably.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "table_tests")
public class Tests {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private Double price;

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
