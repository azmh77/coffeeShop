package com.rhpm.coffeeShop.model.entity;

import com.rhpm.coffeeShop.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CS_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE)
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
    private Date RegisterDate;
    private Date lastPurchase;
    private Date lastPasswordChange;
    private Date lastEmailChange;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<OldUserPasswordEntity> oldUserPasswords;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<OldUserEmailEntity> oldUserEmails;
    private byte incorrectLoginCount;
    @Lob
    private byte[] profileImgUrl;
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String profileImgName;
}
