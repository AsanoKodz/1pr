package com.example.demo.Repository;

import com.example.demo.Models.Star;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StarRepository extends CrudRepository<Star, Long> {
   public List<Star> findByName(String name);
  public List<Star> findByNameContains(String name);
  @Query(value="select * FROM star WHERE classstar=?1", nativeQuery = true)
     List<Star> selectStars(String classstar);

}
