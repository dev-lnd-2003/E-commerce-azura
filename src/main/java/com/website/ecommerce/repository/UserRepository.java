package com.website.ecommerce.repository;

import com.website.ecommerce.entity.User;
import com.website.ecommerce.utils.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("Select u from User u where u.username = ?1")
    Optional<User>  findAccountByUsername(String username);

    @Query(value = "select u from User u where u.username= ?1 and u.password = ?2")
    Optional<User> findByUsernameAndPassword(String username,String password);

    @Query(value = "select u from User u where u.email= ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findAllByRole(@Param("role") Roles role);

    @Query("SELECT u FROM User  u WHERE u.actived =?1")
    List<User> findAllUserLockOrUnlock(Boolean active);
}
