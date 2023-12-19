package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WalletResponseDto;
import com.rhpm.coffeeShop.model.entity.WalletEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService implements com.rhpm.coffeeShop.service.WalletService {
    private final WalletRepository walletRepository;

    @Override
    public WalletResponseDto showWalletBalance(Long id) throws MasterException {
        WalletEntity wallet = walletRepository.findById(id)
                .orElseThrow(() -> new MasterException("کیف پولی یافت نشد!"));
        return ConvertEntityToDto.convertWalletEntityToDto(wallet);
    }
}
