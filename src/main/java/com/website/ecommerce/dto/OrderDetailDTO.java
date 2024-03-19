package com.website.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO implements Serializable {

    private Long id;
    private Double price;
    private Integer quantity;
    private String productName;
    private String productImage;
}
