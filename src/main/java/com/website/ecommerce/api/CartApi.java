package com.website.ecommerce.api;

import com.website.ecommerce.dto.CartDTO;
import com.website.ecommerce.dto.CreateOrderDTO;
import com.website.ecommerce.service.CartService;
import com.website.ecommerce.service.OrderService;
import com.website.ecommerce.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartApi {

    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    UserAddressService userAddressService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> createCart(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "pid") Integer pid){
        CartDTO result = cartService.create(username,pid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/viewCart")
    public ResponseEntity<?> viewCart(@RequestParam(value = "username") String username ){
        List<CartDTO> result = cartService.viewCart(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/check-out")
    public ResponseEntity<CreateOrderDTO> checkout(@RequestBody CreateOrderDTO orderDto){
        CreateOrderDTO result = orderService.create(orderDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/removeCart")
    public void remove(@RequestParam("username") String username){
        cartService.remove(username);
    }

    @DeleteMapping("/removeCartItem")
    public void remove(@RequestParam("username") String username,@RequestParam("pid") Integer pid){
        cartService.removeCartItemByUsernameAndProductId(username,pid);
    }

}
