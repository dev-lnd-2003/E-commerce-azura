package com.website.ecommerce.repository;

import com.website.ecommerce.entity.User;
import com.website.ecommerce.entity.UserAddress;
import com.website.ecommerce.entity.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserPaymentRepository extends JpaRepository<UserPayment,Integer> {

//    @Query("SELECT U FROM UserPayment U WHERE U.user.username = ?1")
//    Optional<UserPayment> findUserPaymentByUsername(String username);
    Optional<UserPayment> findUserPaymentsByUserUsername(String username);

    Optional<UserPayment> findByUser(User user);
}
