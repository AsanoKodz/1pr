package com.example.demo.Repository;

import com.example.demo.Models.InventoryControl;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryControlRepository extends CrudRepository<InventoryControl, Long> {
    public List<InventoryControl> findByDocumentName(String documentName);
    public List<InventoryControl> findByDocumentNameContains(String documentName);
}
