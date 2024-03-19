package com.website.ecommerce.service;

import com.website.ecommerce.dto.AuthenticationRequest;
import com.website.ecommerce.dto.AuthenticationResponse;
import com.website.ecommerce.dto.RegisterRequest;
import com.website.ecommerce.dto.UserDTO;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.utils.Roles;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAll();

    Optional<User> findAccountByUsername(String username);

    User register(RegisterRequest registerRequest);
    User registerAdmin(RegisterRequest registerRequest);

    AuthenticationResponse Authenticate(AuthenticationRequest request);

    UserDTO convertToDTO(User user);

    void lockOrUnlockAccount(String username);

    List<UserDTO> findAllByRole(Roles role);

    List<UserDTO> findAllUserLockOrUnlock(Boolean active);


}
