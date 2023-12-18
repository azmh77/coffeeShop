package com.rhpm.coffeeShop.model.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OldUserEmailResponseDto {
    private Long id;
    private String oldEmail;
    private String newEmail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
    private Long userId;
}
