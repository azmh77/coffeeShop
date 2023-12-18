package com.rhpm.coffeeShop.model.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DiscountResponseDto {
    private Long id;
    private String code;
    private Long userCreateId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}
