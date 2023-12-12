package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_TAGS")
@Data
@RequiredArgsConstructor
public class TagEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "tags_sequence",
            sequenceName = "tags_sequence",
            allocationSize = 40
    )
    @GeneratedValue(
            generator = "tags_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 120, unique = true)
    private String title;
    @ManyToOne
    private UserEntity userCreate;
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
