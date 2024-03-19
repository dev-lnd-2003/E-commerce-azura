package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.CartDTO;
import com.website.ecommerce.entity.Cart;
import com.website.ecommerce.entity.Product;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.repository.CartRepository;
import com.website.ecommerce.repository.ProductRepository;
import com.website.ecommerce.repository.UserRepository;
import com.website.ecommerce.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CartDTO create(String username, Integer productId) {
        Optional<User>  user = userRepository.findAccountByUsername(username);
        Optional<Product>  product = productRepository.findById(productId);

        if (user.isEmpty() || product.isEmpty()) {
            throw new IllegalArgumentException("Account not Found");
        }


        Optional<Cart> optionalCart = cartRepository.findCartByAccountAndProduct(username, productId);
        if (optionalCart.isPresent()) {
            Cart existingCart = optionalCart.get();
            existingCart.setQuantity(existingCart.getQuantity() + 1);
            cartRepository.save(existingCart);
            return convertEntityToDTO(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setUser(user.get());
            newCart.setProduct(product.get());
            newCart.setCreateDate(new Date());
            newCart.setQuantity(1);
            cartRepository.save(newCart);
            return convertEntityToDTO(newCart);
        }
    }

    @Override
    public List<CartDTO> viewCart(String username) {
        return cartRepository.findCartByAccount(username)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void remove(String username) {
         cartRepository.removeProductInCartWhenPayment(username);
    }

    @Override
    public void removeCartItemByUsernameAndProductId(String username,Integer pid) {
        cartRepository.removeCartItemByUsernameAndProductId(username,pid);
    }

    public CartDTO convertEntityToDTO(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }
}
