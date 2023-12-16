package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.OldEmailRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.OldPasswordRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.OldUserEmailResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.OldUserPasswordResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface UserService {
    AuthResponse createUser(UserAuthRequestDto userRequestDto) throws MasterException;

    AuthResponse loginUser(AuthRequest request) throws MasterException;

    UserResponseDto completeUserInfo(UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException, MasterException;

    UserResponseDto getUserById(Long id);

    void deleteUser(Long id);

    Page<UserResponseDto> getUserWithPagination(int offset, int pageSize);

    byte[] getProfilePicUser(Long id) throws MasterException;

    OldUserEmailResponseDto updateEmail(OldEmailRequestDto oldEmailRequestDto) throws MasterException;

    OldUserPasswordResponseDto updatePassword(OldPasswordRequestDto oldPasswordRequestDto) throws MasterException;
}
