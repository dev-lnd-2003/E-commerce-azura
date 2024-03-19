package com.website.ecommerce.service;

import com.website.ecommerce.dto.UserAddressDto;
import com.website.ecommerce.entity.UserAddress;

public interface
UserAddressService {


    UserAddressDto createOrUpdate(String username,UserAddressDto userAddressDto);

    UserAddressDto edit(String username);


}
