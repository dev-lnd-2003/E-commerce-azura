package com.website.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories")
public class Category implements Serializable {

    @Id
    private String id;
    private String name;
    private String photo;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new LinkedHashSet<>();

}