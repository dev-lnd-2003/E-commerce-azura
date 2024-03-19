package com.website.ecommerce.service;

import com.website.ecommerce.dto.UserPaymentDto;

public interface UserPaymentService {

    UserPaymentDto createOrUpdate(String username, UserPaymentDto userPaymentDto);
}
