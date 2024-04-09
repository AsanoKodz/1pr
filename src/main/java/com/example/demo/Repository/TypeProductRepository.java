package com.example.demo.Repository;

import com.example.demo.Models.TypeProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeProductRepository extends CrudRepository<TypeProduct, Long> {
    public List<TypeProduct> findByTypeName(String typeName);
    public List<TypeProduct> findByTypeNameContains(String typeName);
}
