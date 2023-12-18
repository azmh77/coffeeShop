package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CS_Wallet")
@Data
@RequiredArgsConstructor
public class WalletEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @OneToMany
    @JsonIgnore
    private List<TransactionEntity> transaction;
}
