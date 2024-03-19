package com.website.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "User_payment")
public class UserPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 50)
    @Nationalized
    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Size(max = 10)
    @Nationalized
    @Column(name = "provider", length = 10)
    private String provider;

    @Column(name = "expiry")
    private Date expiry;



}