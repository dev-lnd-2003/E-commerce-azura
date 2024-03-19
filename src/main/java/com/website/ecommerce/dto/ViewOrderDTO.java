package com.website.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewOrderDTO {

    private Integer id;
    private Date createDate;
    private List<OrderDetailDTO> orderDetailDTOs;

}
