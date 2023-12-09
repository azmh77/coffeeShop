package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createUser(@RequestBody UserAuthRequestDto userRequestDto) throws MasterException {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) throws MasterException {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @PostMapping("/completeUserInfo")
    public UserResponseDto completeUserInfo2(@ModelAttribute UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException {
        return userService.completeUserInfo(userCompleteDataRequestDto);
    }
}
