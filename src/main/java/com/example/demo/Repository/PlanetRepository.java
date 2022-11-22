package com.example.demo.Repository;

import com.example.demo.Models.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
    public List<Planet> findByName(String name);
    public List<Planet> findByNameContains(String name);


}
