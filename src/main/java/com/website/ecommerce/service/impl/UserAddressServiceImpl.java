package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.CartDTO;
import com.website.ecommerce.dto.UserAddressDto;
import com.website.ecommerce.entity.Cart;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.entity.UserAddress;
import com.website.ecommerce.repository.UserAddressRepository;
import com.website.ecommerce.repository.UserRepository;
import com.website.ecommerce.service.UserAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAddressServiceImpl implements UserAddressService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAddressRepository userAddressRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public UserAddressDto createOrUpdate(String username, UserAddressDto userAddressDto) {
        Optional<User> optionalUser = userRepository.findAccountByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<UserAddress> optionalUserAddress = userAddressRepository.findByUser(user);
            UserAddress userAddress;
            if (optionalUserAddress.isPresent()) {
                userAddress = optionalUserAddress.get();
            } else {
                userAddress = new UserAddress();
                userAddress.setUser(user);
            }
            userAddress.setFullName(userAddressDto.getFullName());
            userAddress.setAddress(userAddressDto.getAddress());
            userAddress.setCity(userAddressDto.getCity());
            userAddress.setPostCode(userAddressDto.getPostCode());
            userAddress.setCountry(userAddressDto.getCountry());
            userAddress.setMobile(userAddressDto.getMobile());

            userAddressRepository.save(userAddress);
            return convertEntityToDTO(userAddress);
        } else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }


    @Override
    public UserAddressDto edit(String username) {
        UserAddress userAddress = userAddressRepository.findUserAddressByUsername(username).get();
        return convertEntityToDTO(userAddress);
    }



    public UserAddressDto convertEntityToDTO(UserAddress userAddress) {
        return modelMapper.map(userAddress, UserAddressDto.class);
    }
}
