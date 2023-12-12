package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_DISCOUNT")
@Data
@RequiredArgsConstructor
public class DiscountEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "discount_sequence",
            sequenceName = "discount_sequence",
            allocationSize = 40
    )
    @GeneratedValue(
            generator = "discount_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 24, unique = true)
    private String code;
    @ManyToOne
    private UserEntity userCreate;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
