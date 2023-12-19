package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CS_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String title;
    @Lob
    @Column(nullable = false, length = 10000)
    private String description;
    @ManyToOne
    @JoinColumn(nullable = false, name = "brandId")
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
    private Long likeCount;
    private Long disLikeCount;
    private Long commentCount;
    @ManyToOne
    @JoinColumn(name = "userCreatedId")
    @JsonIgnore
    private UserEntity userCreated;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserEntity> usersLiked;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserEntity> usersDisLiked;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CommentEntity> comments = new ArrayList<>();
    @Lob
    private Long viewCount;
    private Boolean adminView;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private Long sellCount;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CategoryEntity> category;
    @ManyToOne
    @JoinColumn(name = "weightUnitId")
    private WeightUnitEntity weightUnit;
}
