package com.website.ecommerce.api;

import com.website.ecommerce.dto.*;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.entity.UserAddress;
import com.website.ecommerce.entity.UserPayment;
import com.website.ecommerce.service.UserAddressService;
import com.website.ecommerce.service.UserPaymentService;
import com.website.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AccountResource {

    private final UserService userService;

    private final UserAddressService userAddressService;

    private final UserPaymentService userPaymentService;

    public AccountResource(UserService userService, UserAddressService userAddressService, UserPaymentService userPaymentService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
        this.userPaymentService = userPaymentService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request){
        User result = userService.register(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        AuthenticationResponse result = userService.Authenticate(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/user-address/createOrUpdate")
    public ResponseEntity<?> createUserAddress(@RequestParam("username") String username,
                                               @RequestBody UserAddressDto userAddressDto){
        UserAddressDto result = userAddressService.createOrUpdate(username,userAddressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/user-address/edit")
    public ResponseEntity<UserAddressDto> userAddress(@RequestParam("username") String username){
        UserAddressDto result = userAddressService.edit(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/user-payment-method/createOrUpdate")
    public ResponseEntity<?> createUserPaymentMethod(@RequestParam("username") String username,
                                               @RequestBody UserPaymentDto userPaymentDto){
        UserPaymentDto result = userPaymentService.createOrUpdate(username,userPaymentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
