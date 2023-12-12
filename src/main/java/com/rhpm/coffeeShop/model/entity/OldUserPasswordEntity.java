package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_OLD_USER_PASSWORD")
@Data
@NoArgsConstructor
public class OldUserPasswordEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "oldPassword_sequence",
            sequenceName = "oldPassword_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "oldPassword_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private String oldPassword;
    private String newPassword;
    private Date passwordChangeDate;
    @ManyToOne
    private UserEntity user;
}
