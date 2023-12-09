package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class OldUserEmailResponseDto {
    private Long id;
    private String oldEmail;
    private String newEmail;
    private Date emailChangeDate;
    private Long userId;
}
