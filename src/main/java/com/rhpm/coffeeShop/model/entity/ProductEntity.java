package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    @JoinColumn(nullable = false)
    private BrandEntity brand;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private Long Weight;
    @Column(nullable = false)
    private String productType;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TagEntity> tag;
    @Column(nullable = false)
    private Long inventoryCount;
    @Lob
    @Column(length = 100000)
    private byte[] productImgUrl;
    private String productImgName;
    private Boolean isEnable;
    private Boolean discount;
    @ManyToOne
    private DiscountEntity discountEntity;
    private Long likeCount;
    private Long commentCount;
    @ManyToOne
    private UserEntity userCreated;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserEntity> usersLiked;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CommentEntity> comments;
    private Long viewCount;
    private Boolean adminView;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private Long sellCount;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CategoryEntity> category;
    @OneToOne
    private WeightUnitEntity weightUnit;
}
