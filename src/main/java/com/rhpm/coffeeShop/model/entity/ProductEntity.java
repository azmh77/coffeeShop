package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CS_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "product_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private BrandEntity brand;
    private String price;
    private Integer Weight;
    private String productType;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TagEntity> tag;
    private Integer inventoryCount;
    private byte[] profileImgUrl;
    private String profileImgName;
    private Boolean isEnable;
    private Boolean discount;
    private Integer likeCount;
    @ManyToOne
    private UserEntity userCreated;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserEntity> usersLiked;
    @ManyToMany
    private List<PropertyEntity> propertys;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CommentEntity> comments;
}
