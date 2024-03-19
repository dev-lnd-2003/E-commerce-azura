package com.website.ecommerce.service;

import com.website.ecommerce.dto.CartDTO;
import com.website.ecommerce.entity.Cart;

import java.util.List;

public interface CartService {

    CartDTO create(String username, Integer productId);

    List<CartDTO> viewCart(String username);

    void remove(String username);

    void removeCartItemByUsernameAndProductId(String username,Integer pid);

}
