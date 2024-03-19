package com.website.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Product_Inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Create_date")
    private Date createDate;

    @OneToMany(mappedBy = "inventory")
    private Set<Product> products = new LinkedHashSet<>();

}