package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CS_COMMENTS")
@Data
@RequiredArgsConstructor
public class CommentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String body;
    @ManyToOne
    private UserEntity userCreated;
    @ManyToOne
    private CommentEntity parent;
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<CommentEntity> children = new ArrayList<>();
    @CreationTimestamp
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
