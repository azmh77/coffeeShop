package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CS_PRODUCT_PIC")
@Data
@RequiredArgsConstructor
public class ProductPicEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "productPic_sequence",
            sequenceName = "productPic_sequence",
            allocationSize = 40
    )
    @GeneratedValue(
            generator = "productPic_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Lob
    @Column(length = 100000)
    private byte[] productImgUrl;
}
