package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.AuthenticationRequest;
import com.website.ecommerce.dto.AuthenticationResponse;
import com.website.ecommerce.dto.RegisterRequest;
import com.website.ecommerce.dto.UserDTO;
import com.website.ecommerce.entity.User;

import com.website.ecommerce.jwt.JwtService;
import com.website.ecommerce.repository.UserRepository;
import com.website.ecommerce.service.UserService;
import com.website.ecommerce.utils.Roles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findAccountByUsername(String username) {
        return userRepository.findAccountByUsername(username);
    }


    private final AuthenticationManager authenticationManager;

    @Override
    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Roles.CUSTOMER);
        user.setActived(true);
        user.setPhoto("https://i.pinimg.com/736x/0e/80/8e/0e808e79ce959e6ef388579e3969927b.jpg");
        return userRepository.save(user);

    }

    @Override
    public User registerAdmin(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Roles.ADMIN);
        user.setActived(true);
        user.setPhoto("https://i.pinimg.com/736x/0e/80/8e/0e808e79ce959e6ef388579e3969927b.jpg");
        return userRepository.save(user);
    }

    @Override
    public AuthenticationResponse Authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findAccountByUsername(request.getUsername())
                .orElseThrow();
        var jwt = jwtService.generateToken(user);

        var userDto = convertToDTO(user);

        return AuthenticationResponse
                .builder()
                .token(jwt)
                .userDto(userDto)
                .build();
    }



    @Override
    public UserDTO convertToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void lockOrUnlockAccount(String username) {
        User user = userRepository.findAccountByUsername(username).get();
        if (user.getActived()){
            user.setActived(false);
            userRepository.save(user);
        }else{
            user.setActived(true);
            userRepository.save(user);
        }
    }

    @Override
    public List<UserDTO> findAllByRole(Roles role) {
        return userRepository
                .findAllByRole(role)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAllUserLockOrUnlock(Boolean active) {
        return userRepository
                .findAllUserLockOrUnlock(active)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
