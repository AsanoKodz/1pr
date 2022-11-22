package com.example.demo.Repository;

import com.example.demo.Models.Sputnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SputnikRepository extends CrudRepository<Sputnik, Long> {
    public List<Sputnik> findByName(String name);
    public List<Sputnik> findByNameContains(String name);
    @Query(value="select * FROM star WHERE planeta=?1", nativeQuery = true)
    List<Sputnik> selectSputnik(String planeta);

}
