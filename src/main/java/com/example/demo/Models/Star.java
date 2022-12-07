package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    public  String name;

    public  String classstar;

    public Integer lumen;

    public Star() {
    }

    public Star(String name, String classstar, Integer lumen) {
        this.name = name;
        this.classstar = classstar;
        this.lumen = lumen;
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

    public String getclassstar() {
        return classstar;
    }

    public void setclassstar(String classstar) {
        this.classstar = classstar;
    }

    public Integer getlumen() {
        return lumen;
    }

    public void setlumen(Integer lumen) {
        this.lumen = lumen;
    }
}
