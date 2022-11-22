package com.example.demo.controllers;

import com.example.demo.Models.Planet;
import com.example.demo.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/planet")
public class PlanetController {
    @Autowired
    PlanetRepository planetRepository;

    @GetMapping("/")
    public String planet(Model model){
        Iterable<Planet> planetIterable =  planetRepository.findAll();
        model.addAttribute("planet_list", planetIterable);
        return "planet/planet";
    }

    @GetMapping("/add")
    public String AddView()
    {
        return "planet/planet-add";
    }

    @PostMapping("/add")
    public String AddPlanet(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "rasstotsol") double rasstotsol,
            @RequestParam(name = "diametr") double diametr,
            @RequestParam(name = "prodgoda") double prodgoda,
            @RequestParam(name = "kolsput") int kolsput
    )
    {
        Planet new_planet = new Planet(name, rasstotsol, diametr, prodgoda, kolsput);
        planetRepository.save(new_planet);
        return "redirect:/planet/";
    }

    @GetMapping("/filter/")
    public  String filter(@RequestParam(name = "name") String name_planet, Model model)
    {
        List<Planet> planetList= planetRepository.findByName(name_planet);
        model.addAttribute("planet_list", planetList);
        return "planet/planet";
    }

    @GetMapping("/filtercontains/")
    public  String filtercontains(@RequestParam(name = "name") String name_planet, Model model)
    {
        List<Planet> planetList= planetRepository.findByNameContains(name_planet);
        model.addAttribute("planet_list", planetList);
        return "planet/planet";
    }

    @GetMapping("/detail/{id}")
    public String detailPlanet(@PathVariable Long id, Model model)
    {
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        model.addAttribute("one_planet", planet_obj);
        return "planet/info";
    }
}
