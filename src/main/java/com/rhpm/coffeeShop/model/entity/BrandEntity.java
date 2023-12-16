package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_BRANDS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60, unique = true)
    private String brandName;
    @Column(nullable = false, length = 100000)
    @Lob
    private String brandAbout;
    @Lob
    @Column(length = 100000)
    private byte[] brandImgUrl;
    private String brandImgName;
    @ManyToOne
    private UserEntity userCreated;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
