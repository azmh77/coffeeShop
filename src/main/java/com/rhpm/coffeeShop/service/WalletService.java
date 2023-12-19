package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.responseDto.WalletResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

public interface WalletService {
    WalletResponseDto showWalletBalance(Long id) throws MasterException;
}
