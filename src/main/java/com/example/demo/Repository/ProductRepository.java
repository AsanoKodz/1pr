package com.example.demo.Repository;

import com.example.demo.Models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findByProductName(String productName);
    public List<Product> findByProductNameContains(String productName);
}
