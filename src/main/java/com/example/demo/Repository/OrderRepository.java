package com.example.demo.Repository;

import com.example.demo.Models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    public List<Order> findByOrderName(String orderName);
    public List<Order> findByOrderNameContains(String orderName);
}
