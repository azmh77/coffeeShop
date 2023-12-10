package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public UserResponseDto completeUserInfo(@ModelAttribute UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException, MasterException {
        return userService.completeUserInfo(userCompleteDataRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping()
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<UserEntity>> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<UserEntity> productsWithPagination = userService.getUserWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }
}
