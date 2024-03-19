package com.website.ecommerce.dto;

import com.website.ecommerce.entity.Orders;
import com.website.ecommerce.entity.OrderDetail;
import com.website.ecommerce.entity.UserPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * DTO for {@link Orders}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO implements Serializable {

    private Orders order;
    private Set<OrderDetail> orderDetails;
    private Date createDate = new Date();
    private UserPayment userPayment;


}