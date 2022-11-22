package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sputnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    public  String name;

    public  String planeta;

    public  Double ves;

    public  String strana;

    public  Double years;

    public Sputnik() {
    }

    public Sputnik(String name, String planeta, Double ves, String strana, Double years) {
        this.name = name;
        this.planeta = planeta;
        this.ves = ves;
        this.strana = strana;
        this.years = years;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }

    public String getplaneta() {
        return planeta;
    }

    public void setplaneta(String planeta) {
        planeta = planeta;
    }

    public Double getves() {
        return ves;
    }

    public void setves(Double ves) {
        ves = ves;
    }

    public String getstrana() {
        return strana;
    }

    public void setstrana(String strana) {
        strana = strana;
    }

    public Double getYears() {
        return years;
    }

    public void setyears(Double years) {
        years = years;
    }
}

