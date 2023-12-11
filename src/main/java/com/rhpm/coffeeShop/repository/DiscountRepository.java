package com.rhpm.coffeeShop.repository;

import com.rhpm.coffeeShop.model.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
}
