package com.rhpm.coffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CS_COMMENTS")
@Data
@RequiredArgsConstructor
public class CommentEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "comments_sequence",
            sequenceName = "comments_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "comments_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Lob
    private String body;
    @ManyToOne
    private UserEntity userCreated;
    @ManyToOne
    private ProductEntity product;
}
