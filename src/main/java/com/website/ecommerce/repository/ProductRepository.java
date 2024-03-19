package com.website.ecommerce.repository;

import com.website.ecommerce.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.category.id=?1")
    Page<Product> findAllProductByCategoryId(String cid, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category.id=?1")
    List<Product> findAllProductByCategoryId(String cid);

    @Query("SELECT p From Product  p WHERE p.id = ?1")
    Optional<Product> findProductById(Integer pid);

    @Query("select  p from Product p join p.orderDetails o GROUP BY p ORDER BY SUM(o.quantity) DESC ")
    List<Product> bestSeller();
}
