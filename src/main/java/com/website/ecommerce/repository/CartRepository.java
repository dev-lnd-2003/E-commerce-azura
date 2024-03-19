package com.website.ecommerce.repository;

import com.website.ecommerce.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query(value = "select c from Cart c where c.user.username = ?1")
    List<Cart> findCartByAccount(String username);

    @Query(value = "select c from Cart c where c.user.username = ?1 and c.product.id = ?2")
    Optional<Cart> findCartByAccountAndProduct(String username,Integer productId);

    @Query(value = "select c from Cart c where c.product.name = ?1")
    Cart findProductInCartByName(String name);

    @Transactional
    @Modifying
    @Query(value = "delete from Cart where Cart.username = ?1", nativeQuery = true)
    void removeProductInCartWhenPayment(String username);

    @Query(value = "select coalesce(sum(c.quantity), 0) from Cart c where c.user.username = ?1")
    int getAmount(String username);

    @Transactional
    @Modifying
    @Query("delete from Cart c where c.user.username = ?1 and c.product.id = ?2")
    void removeCartItemByUsernameAndProductId(String username, Integer productId);



}
