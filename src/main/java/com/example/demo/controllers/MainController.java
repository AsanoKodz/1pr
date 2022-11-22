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
    public String awst(@RequestParam(required = false) Double a, Double b, String mod, Model model){
        double recr = 0;

        return "Home";
    }

}


