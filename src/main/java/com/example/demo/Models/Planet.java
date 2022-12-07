package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    public   String name;

    public  Double rasstotsol;

    public  Double diametr;

    public  Double prodgoda;

    public  Integer kolsput;

    public Planet() {
    }

    public Planet(String name, Double rasstotsol, Double diametr, Double prodgoda, Integer kolsput) {
        this.name = name;
        this.rasstotsol = rasstotsol;
        this.diametr = diametr;
        this.prodgoda = prodgoda;
        this.kolsput = kolsput;
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
        this.name = name;
    }

    public Double getrasstotsol() {
        return rasstotsol;
    }

    public void setrasstotsol(Double rasstotsol) {
        this.rasstotsol = rasstotsol;
    }

    public Double getdiametr() {
        return diametr;
    }

    public void setdiametr(Double diametr) {
        this.diametr = diametr;
    }

    public Double getprodgoda() {
        return prodgoda;
    }

    public void setprodgoda(Double prodgoda) {
        this.prodgoda = prodgoda;
    }

    public Integer getkolsput() {
        return kolsput;
    }

    public void setkolsput(Integer kolsput) {
        this.kolsput = kolsput;
    }
}
