package com.website.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.website.ecommerce.entity.Cart}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO implements Serializable {
    String userUsername;
    Date createDate;
    Integer productId;
    String productName;
    String productImage;
    Double productPrice;
    Integer quantity;
}