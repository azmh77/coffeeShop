package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.responseDto.WalletResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/walletBalance")
@CrossOrigin("*")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @GetMapping("/{id}")
    public WalletResponseDto showWalletBalance(@PathVariable Long id) throws MasterException {
        return walletService.showWalletBalance(id);
    }
}
