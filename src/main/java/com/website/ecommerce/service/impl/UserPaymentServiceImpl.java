package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.UserAddressDto;
import com.website.ecommerce.dto.UserPaymentDto;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.entity.UserAddress;
import com.website.ecommerce.entity.UserPayment;
import com.website.ecommerce.repository.UserPaymentRepository;
import com.website.ecommerce.repository.UserRepository;
import com.website.ecommerce.service.UserPaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserPaymentDto createOrUpdate(String username, UserPaymentDto userPaymentDto) {
        Optional<User> optionalUser = userRepository.findAccountByUsername(username);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            Optional<UserPayment> optionalUserPayment = userPaymentRepository.findByUser(user);
            UserPayment userPayment;
            if (optionalUserPayment.isPresent()){
                userPayment = optionalUserPayment.get();
            }else{
                userPayment = new UserPayment();
                userPayment.setUser(user);
            }

            userPayment.setPaymentType(userPaymentDto.getPaymentType());
            userPayment.setExpiry(userPaymentDto.getExpiry());
            userPayment.setProvider(userPaymentDto.getProvider());
            userPaymentRepository.save(userPayment);
            return convertEntityToDTO(userPayment);
        }else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }

    public UserPaymentDto convertEntityToDTO(UserPayment userPayment) {
        return modelMapper.map(userPayment, UserPaymentDto.class);
    }
}
