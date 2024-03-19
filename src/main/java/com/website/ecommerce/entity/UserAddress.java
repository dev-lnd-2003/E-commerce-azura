package com.website.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "User_Address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 50)
    @Nationalized
    @Column(name = "full_name", length = 50)
    private String fullName;


    @Size(max = 50)
    @Nationalized
    @Column(name = "address", length = 50)
    private String address;

    @Size(max = 50)
    @Nationalized
    @Column(name = "city", length = 50)
    private String city;

    @Size(max = 50)
    @Nationalized
    @Column(name = "post_code", length = 50)
    private String postCode;

    @Size(max = 50)
    @Nationalized
    @Column(name = "country", length = 50)
    private String country;

    @Size(max = 50)
    @Nationalized
    @Column(name = "mobile", length = 50)
    private String mobile;

}