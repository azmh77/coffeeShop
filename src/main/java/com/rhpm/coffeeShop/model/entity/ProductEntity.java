package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
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
    @Column(nullable = false, length = 60)
    private String title;
    @Lob
    @Column(nullable = false, length = 10000)
    private String description;
    @ManyToOne
    @Column(nullable = false)
    private BrandEntity brand;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private Integer Weight;
    @Column(nullable = false)
    private String productType;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TagEntity> tag;
    @Column(nullable = false)
    private Integer inventoryCount;
    @Lob
    @Column(length = 100000)
    private List<byte[]> productImgUrl;
    private String productImgName;
    private Boolean isEnable;
    private Boolean discount;
    @ManyToOne
    private DiscountEntity discountEntity;
    private Integer likeCount;
    @ManyToOne
    private UserEntity userCreated;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserEntity> usersLiked;
    @ManyToMany
    private List<PropertyEntity> propertys;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CommentEntity> comments;
    private Long viewCount;
    private Boolean adminView;
    private Date created;
    private Date updated;
    private Long sellCount;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CategoryEntity> category;
}
