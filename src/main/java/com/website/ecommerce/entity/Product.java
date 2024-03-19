package com.website.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Image", nullable = false, length = 50)
    private String image;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "CreateDate", nullable = false)
    private Date createDate;

    @NotNull
    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "CategoryId")
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Inventory_Id")
    private ProductInventory inventory;

}