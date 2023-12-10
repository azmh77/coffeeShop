package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

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
    private String title;
}
