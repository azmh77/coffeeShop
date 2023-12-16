package com.rhpm.coffeeShop.repository;

import com.rhpm.coffeeShop.model.entity.OldUserPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OldPasswordRepository extends JpaRepository<OldUserPasswordEntity, Long> {
}
