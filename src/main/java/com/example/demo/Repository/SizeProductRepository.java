package com.example.demo.Repository;

import com.example.demo.Models.SizeProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SizeProductRepository extends CrudRepository<SizeProduct, Long> {
    public List<SizeProduct> findBySizeName(String sizeName);
    public List<SizeProduct> findBySizeNameContains(String sizeName);
}
