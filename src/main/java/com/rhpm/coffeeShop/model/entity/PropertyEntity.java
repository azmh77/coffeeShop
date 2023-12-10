package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CS_PROPERTY")
@Data
@RequiredArgsConstructor
public class PropertyEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "property_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
}
