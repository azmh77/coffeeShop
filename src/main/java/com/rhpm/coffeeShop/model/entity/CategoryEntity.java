package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
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
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "category_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 60, unique = true)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PropertyEntity> products;
}
