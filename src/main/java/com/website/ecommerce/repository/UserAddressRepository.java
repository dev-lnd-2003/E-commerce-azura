package com.website.ecommerce.repository;

import com.website.ecommerce.entity.User;
import com.website.ecommerce.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {

    @Query("SELECT U FROM UserAddress U WHERE U.user.username = ?1")
    Optional<UserAddress> findUserAddressByUsername(String username);

    Optional<UserAddress> findByUser(User user);

}
