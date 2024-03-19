package com.website.ecommerce.service;

import com.website.ecommerce.dto.CreateOrderDTO;
import com.website.ecommerce.dto.ViewOrderDTO;

import java.util.List;

public interface OrderService {

    CreateOrderDTO create(CreateOrderDTO orderDto);

    List<ViewOrderDTO> findOrderByUser_Username(String username);

}
