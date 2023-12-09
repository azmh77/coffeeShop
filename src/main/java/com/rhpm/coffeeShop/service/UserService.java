package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.io.IOException;

public interface UserService {
    AuthResponse createUser(UserAuthRequestDto userRequestDto) throws MasterException;

    AuthResponse loginUser(AuthRequest request);

    UserResponseDto completeUserInfo(UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException;
}
