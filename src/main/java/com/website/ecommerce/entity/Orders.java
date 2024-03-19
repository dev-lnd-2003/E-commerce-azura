package com.website.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Username", nullable = false)
    private User user;

    @Column(name = "CreateDate", nullable = false)
    private Date createDate;

    @JsonIgnore
    @OneToMany(mappedBy = "order",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();





}