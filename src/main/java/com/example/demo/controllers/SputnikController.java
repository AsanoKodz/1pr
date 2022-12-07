package com.example.demo.controllers;

import com.example.demo.Models.Sputnik;
import com.example.demo.Repository.SputnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sputnik")
public class SputnikController {
    @Autowired
    SputnikRepository sputnikRepository;

    @GetMapping("/")
    public String sputnik(Model model){
        Iterable<Sputnik> sputnikIterable =  sputnikRepository.findAll();
        model.addAttribute("sputnik_list", sputnikIterable);
        return "sputnik/sputnik";
    }

    @GetMapping("/add")
    public String AddView()
    {
        return "sputnik/sputnik-add";
    }

    @PostMapping("/add")
    public String AddSputnik(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "planeta") String planeta,
            @RequestParam(name = "ves") double ves,
            @RequestParam(name = "strana") String strana,
            @RequestParam(name = "years") double years
    )
    {
        Sputnik new_sputnik = new Sputnik(name, planeta, ves, strana, years);
        sputnikRepository.save(new_sputnik);
        return "redirect:/sputnik/";
    }

    @GetMapping("/filter/")
    public  String filter(@RequestParam(name = "name") String name_sputnik, Model model)
    {
        List<Sputnik> sputnikList= sputnikRepository.findByName(name_sputnik);
        model.addAttribute("sputnik_list", sputnikList);
        return "sputnik/sputnik";
    }

    @GetMapping("/filtercontains/")
    public  String filtercontains(@RequestParam(name = "name") String name_sputnik, Model model)
    {
        List<Sputnik> sputnikList= sputnikRepository.findByNameContains(name_sputnik);
        model.addAttribute("sputnik_list", sputnikList);
        return "sputnik/sputnik";
    }

    @GetMapping("/detail/{id}")
    public String detailSputnik(@PathVariable Long id, Model model)
    {
        Sputnik sputnik_obj = sputnikRepository.findById(id).orElseThrow();
        model.addAttribute("one_sputnik", sputnik_obj);
        return "sputnik/info";
    }

    @PostMapping("/detail/{id}/del")
    public String delSputnik(@PathVariable Long id)
    {
        Sputnik sputnik_obj = sputnikRepository.findById(id).orElseThrow();
        sputnikRepository.delete(sputnik_obj);
        return "redirect:/sputnik/";
    }

    @GetMapping ("/detail/{id}/upd")
    public String updateSputnik(
            @PathVariable Long id, Model model)
    {
        model.addAttribute("object", sputnikRepository.findById(id).orElseThrow());
        return "sputnik/update";
    }


    @PostMapping("/detail/{id}/upd")
    public  String update(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String planeta,
            @RequestParam Double ves,
            @RequestParam String strana,
            @RequestParam Double years
    )
    {
        Sputnik sputnik = sputnikRepository.findById(id).orElseThrow();

        sputnik.setname(name);
        sputnik.setplaneta(planeta);
        sputnik.setves(ves);
        sputnik.setstrana(strana);
        sputnik.setyears(years);
        sputnikRepository.save(sputnik);
        return "redirect:/sputnik/detail/" + sputnik.getid();
    }

}
