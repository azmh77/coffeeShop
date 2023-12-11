package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class DiscountResponseDto {
    private Long id;
    private String code;
    private Long userCreateId;
    private Date createAt;
    private Date updateAt;
}
