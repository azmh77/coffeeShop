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
    @Column(nullable = false, length = 60, unique = true)
    private String brandName;
    @Column(nullable = false, length = 10000)
    @Lob
    private String brandAbout;
    @Lob
    @Column(length = 100000)
    private byte[] brandImgUrl;
    private String brandImgName;
}
