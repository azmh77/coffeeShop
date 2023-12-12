package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class WeightUnitResponseDto {
    private Long id;
    private String title;
    private Long userCreateId;
    private Date createAt;
    private Date updateAt;
}
