package com.website.ecommerce.entity;

import com.website.ecommerce.utils.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @Size(max = 50)
    @Nationalized
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Fullname", length = 50)
    private String fullname;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "Password", nullable = false)
    private String password;

    @Nationalized
    @Lob
    @Column(name = "Photo")
    private String photo;

    @Column(name = "Actived")
    private Boolean actived;

    @Enumerated(EnumType.STRING)
    private Roles role;

//    @OneToMany(mappedBy = "username")
//    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserAddress> userAddresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserPayment> userPayments = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}