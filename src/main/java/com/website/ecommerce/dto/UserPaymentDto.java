package com.website.ecommerce.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link com.website.ecommerce.entity.UserPayment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentDto implements Serializable {

    Integer id;
    String userUsername;
    String paymentType;
    String provider;
    Date expiry;
}