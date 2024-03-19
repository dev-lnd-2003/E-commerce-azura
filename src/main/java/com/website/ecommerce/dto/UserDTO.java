package com.website.ecommerce.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.website.ecommerce.entity.User}
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO implements Serializable {
    String username;
    String fullname;
    String email;
    String photo;
    Boolean actived;
    String role;
}