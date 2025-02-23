package com.example.school;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder

public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    public School(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public School(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
       return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
