package com.rhpm.coffeeShop.repository;

import com.rhpm.coffeeShop.model.entity.OldUserEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OldEmailRepository extends JpaRepository<OldUserEmailEntity, Long> {
}
