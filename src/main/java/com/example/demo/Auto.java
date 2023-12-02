package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Mark;
    private String Name;
    private int Price;
    private int Mileage;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getMark() {
        return Mark;
    }


    public void setMark(String Mark) {
        this.Mark = Mark;
    }

    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }


    public int getPrice() {
        return Price;
    }


    public void setPrice(int Price) {
        this.Price = Price;
    }


    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int Mileage) {
        this.Mileage = Mileage;
    }
}
