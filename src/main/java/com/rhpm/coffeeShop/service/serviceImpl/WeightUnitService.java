package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.entity.WeightUnitEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.WeightUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WeightUnitService implements com.rhpm.coffeeShop.service.WeightUnitService {
    private final WeightUnitRepository weightUnitRepository;

    @Override
    public WeightUnitResponseDto createWeightUnit(WeightUnitRequestDto weightUnitRequestDto) throws MasterException {
        Optional<WeightUnitEntity> weightUnit = weightUnitRepository.findByTitle(weightUnitRequestDto.getTitle());
        if (weightUnitRequestDto.getTitle().isEmpty()) {
            throw new MasterException("فیلد ها نباید خالی باشند!");
        } else if (weightUnitRequestDto.getTitle().length() > 12) {
            throw new MasterException("تعداد کارکتر برای واحد وزن باید کمتر از 12 کاراکتر باشد!");
        } else if (weightUnit.isPresent()) {
            throw new MasterException("نام برند تکراری است!");
        } else {
            
        }
    }
}
