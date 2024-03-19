package com.website.ecommerce.api;


import com.website.ecommerce.dto.ViewOrderDTO;
import com.website.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderApi {

    private final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/viewOrder")
    public ResponseEntity<List<ViewOrderDTO>> viewOrder(@RequestParam("username") String username){
        List<ViewOrderDTO> result = orderService.findOrderByUser_Username(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
