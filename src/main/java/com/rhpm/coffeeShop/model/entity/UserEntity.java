package com.rhpm.coffeeShop.model.entity;

import com.rhpm.coffeeShop.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CS_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String firstName;
    @Column(nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 320, unique = true)
    private String email;
    private Boolean emailConfirmation;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(length = 15, unique = true)
    private String phoneNumber;
    private Boolean phoneNumberConfirmation;
    @Column(length = 10, unique = true)
    private String nationalCode;
    @Column(length = 60)
    private String state;
    @Column(length = 60)
    private String city;
    @Column(length = 320)
    @Lob
    private String address;
    @Column(length = 10)
    private String zipCode;
    private String currentWalletBalance;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isActive;
    @CreationTimestamp
    private LocalDateTime RegisterDate;
    private LocalDateTime lastPurchase;
    private LocalDateTime lastEmailChange;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<OldUserEmailEntity> oldUserEmails;
    private byte incorrectLoginCount;
    private Boolean isCompleteData = false;
    private Integer completeDataCount = 0;
    @Lob
    @Column(length = 100000)
    private byte[] profileImgUrl;
    private String profileImgName;
    @Lob
    private String CSID;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
