package com.website.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Username")
    private User user;

    @Column(name = "Create_Date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Id")
    private Product product;

    @Column(name = "Quantity")
    private Integer quantity;

}