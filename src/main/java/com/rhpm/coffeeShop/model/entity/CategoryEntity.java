package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CS_CATEGORY")
@Data
@RequiredArgsConstructor
public class CategoryEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 40
    )
    @GeneratedValue(
            generator = "category_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 60, unique = true)
    private String title;
    @ManyToOne
    private UserEntity userCreateId;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
