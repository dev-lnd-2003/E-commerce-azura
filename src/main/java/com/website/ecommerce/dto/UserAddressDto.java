package com.website.ecommerce.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.website.ecommerce.entity.UserAddress}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDto implements Serializable {

    String userUsername;
    String fullName;
    String address;
    String city;
    String postCode;
    String country;
    String mobile;
}