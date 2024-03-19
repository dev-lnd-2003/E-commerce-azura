package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.CreateOrderDTO;
import com.website.ecommerce.dto.OrderDetailDTO;
import com.website.ecommerce.dto.ViewOrderDTO;
import com.website.ecommerce.entity.*;
import com.website.ecommerce.repository.*;
import com.website.ecommerce.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateOrderDTO create(CreateOrderDTO orderDto) {
        Orders order = orderDto.getOrder();
        order.setCreateDate(orderDto.getCreateDate());
        orderRepository.save(order);
        Set<OrderDetail> orderDetails = orderDto.getOrderDetails();
        orderDetails.forEach(orderDetail -> {
            orderDetail.setOrder(order);
            orderDetailRepository.save(orderDetail);
        });
        return convertOrderToCreateOrderDTO(order);
    }

    @Override
    public List<ViewOrderDTO> findOrderByUser_Username(String username) {
        return orderRepository.findOrderByUser_Username(username)
                .stream()
                .map(this::convertOrderToViewOrderDTO)
                .collect(Collectors.toList());
    }

    public CreateOrderDTO convertOrderToCreateOrderDTO(Orders order) {
        return modelMapper.map(order, CreateOrderDTO.class);
    }

    public ViewOrderDTO convertOrderToViewOrderDTO(Orders order){
        ViewOrderDTO viewOrderDTO = modelMapper.map(order, ViewOrderDTO.class);
        List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetails().stream()
                .map(this::convertOrderDetailToDTO)
                .collect(Collectors.toList());
        viewOrderDTO.setOrderDetailDTOs(orderDetailDTOs);
        return viewOrderDTO;
    }

    private OrderDetailDTO convertOrderDetailToDTO(OrderDetail orderDetail) {
        return modelMapper.map(orderDetail,OrderDetailDTO.class);
    }
}
