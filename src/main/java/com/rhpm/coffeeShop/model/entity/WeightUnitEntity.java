package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_WEIGHT_UNIT")
@Data
@RequiredArgsConstructor
public class WeightUnitEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "weightUnit_sequence",
            sequenceName = "weightUnit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "weightUnit_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 12, unique = true)
    private String title;
    @ManyToOne
    private UserEntity userCreate;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
