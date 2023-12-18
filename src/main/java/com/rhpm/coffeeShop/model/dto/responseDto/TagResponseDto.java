package com.rhpm.coffeeShop.model.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TagResponseDto {
    private Long id;
    private String title;
    private Long userCreateId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}
