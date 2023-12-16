package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_OLD_USER_PASSWORD")
@Data
@NoArgsConstructor
public class OldUserPasswordEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String oldPassword;
    @Column(nullable = false, length = 60)
    private String newPassword;
    @UpdateTimestamp
    private Date updateAt;
    @ManyToOne
    private UserEntity user;
}
