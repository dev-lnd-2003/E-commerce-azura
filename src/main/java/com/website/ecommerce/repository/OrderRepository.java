package com.website.ecommerce.repository;

import com.website.ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findOrderByUser_Username(String username);
}
