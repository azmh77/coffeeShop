package com.rhpm.coffeeShop.repository;

import com.rhpm.coffeeShop.model.entity.WeightUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightUnitRepository extends JpaRepository<WeightUnitEntity, Long> {
    Optional<WeightUnitEntity> findByTitle(String title);
}
