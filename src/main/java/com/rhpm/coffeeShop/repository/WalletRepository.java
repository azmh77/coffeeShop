package com.rhpm.coffeeShop.repository;

import com.rhpm.coffeeShop.model.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
}
