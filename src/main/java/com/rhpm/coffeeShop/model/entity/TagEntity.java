package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CS_TAGS")
@Data
@RequiredArgsConstructor
public class TagEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "tags_sequence",
            sequenceName = "tags_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "tags_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 120, unique = true)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProductEntity> products;
}
