package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CS_BRANDS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "brands_sequence",
            sequenceName = "brands_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "brands_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brandName;
    private String brandAbout;
}
