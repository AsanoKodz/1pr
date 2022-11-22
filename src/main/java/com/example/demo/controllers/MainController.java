package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Console;

@Controller

public class MainController {
    @GetMapping("/home")
    public String index(){
        return "Home";
    }

    @GetMapping("/about")
    public String as(@RequestParam(name="a", required = false, defaultValue = "Привет") String a, Model model){
        model.addAttribute("temp", a);
        model.addAttribute("err", "Привет");
        System.out.println(a);
        return "Info";
    }
    @PostMapping("/about")
    public String ast(@RequestParam(required = false) Double a, Double b, String mod, Model model){
        double rec = 0;
        model.addAttribute("temp", a);
        model.addAttribute("tempt", b);
        if (mod.contains("a1")){
            rec=a*b;
        }
        if (mod.contains("a2")){
            rec=a-b;
        }
        if (mod.contains("a3")){
            if (b==0) {rec=0;}
            else rec=a/b;
        }
        if (mod.contains("a4")){
            rec=a+b;
        }
        model.addAttribute("temt", rec);
        System.out.println(a);
        return "Info";
    }
}


