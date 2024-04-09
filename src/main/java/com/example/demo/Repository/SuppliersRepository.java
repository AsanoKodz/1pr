package com.example.demo.Repository;

import com.example.demo.Models.Suppliers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SuppliersRepository extends CrudRepository<Suppliers, Long> {
    public List<Suppliers> findBySuppliersName(String suppliersName);
    public List<Suppliers> findBySuppliersNameContains(String suppliersName);
}
