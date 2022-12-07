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

    @PostMapping("/detail/{id}/del")
    public String delPlanet(@PathVariable Long id)
    {
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        planetRepository.delete(planet_obj);
        return "redirect:/planet/";
    }

    @GetMapping ("/detail/{id}/upd")
    public String updatePlanet(
            @PathVariable Long id, Model model)
    {
        model.addAttribute("object", planetRepository.findById(id).orElseThrow());
        return "planet/update";
    }

    @PostMapping("/detail/{id}/upd")
    public  String update(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Double rasstotsol,
            @RequestParam Double diametr,
            @RequestParam Double prodgoda,
            @RequestParam Integer kolsput
    )
    {
        Planet planet = planetRepository.findById(id).orElseThrow();

        planet.setname(name);
        planet.setrasstotsol(rasstotsol);
        planet.setdiametr(diametr);
        planet.setprodgoda(prodgoda);
        planet.setkolsput(kolsput);
        planetRepository.save(planet);
        return "redirect:/planet/detail/" + planet.getid();
    }
}
