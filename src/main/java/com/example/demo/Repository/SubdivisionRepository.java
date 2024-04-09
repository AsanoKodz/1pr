package com.example.demo.Repository;

import com.example.demo.Models.Subdivision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubdivisionRepository extends CrudRepository<Subdivision, Long> {
    public List<Subdivision> findBySubdivisionName(String subdivisionName);
    public List<Subdivision> findBySubdivisionNameContains(String subdivisionName);
}
