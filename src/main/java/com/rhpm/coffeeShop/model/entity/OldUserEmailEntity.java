package com.rhpm.coffeeShop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CS_OLD_USER_EMAIL")
@Data
@NoArgsConstructor
public class OldUserEmailEntity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "oldEmail_sequence",
            sequenceName = "oldEmail_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "oldEmail_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private String oldEmail;
    private String newEmail;
    private Date emailChangeDate;
    @ManyToOne
    private UserEntity user;
}
