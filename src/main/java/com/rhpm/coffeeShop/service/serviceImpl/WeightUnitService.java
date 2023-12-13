package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.entity.WeightUnitEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.UserRepository;
import com.rhpm.coffeeShop.repository.WeightUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WeightUnitService implements com.rhpm.coffeeShop.service.WeightUnitService {
    private final WeightUnitRepository weightUnitRepository;
    private final UserRepository userRepository;

    @Override
    public WeightUnitResponseDto createWeightUnit(WeightUnitRequestDto weightUnitRequestDto) throws MasterException {
        Optional<WeightUnitEntity> weightUnit = weightUnitRepository.findByTitle(weightUnitRequestDto.getTitle());
        WeightUnitEntity weightUnitEntity = new WeightUnitEntity();
        UserEntity user = userRepository.findById(weightUnitRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (weightUnitRequestDto.getTitle().isEmpty()) {
                throw new MasterException("فیلد ها نباید خالی باشند!");
            } else if (weightUnitRequestDto.getTitle().length() > 12) {
                throw new MasterException("تعداد کارکتر برای واحد وزن باید کمتر از 12 کاراکتر باشد!");
            } else if (weightUnit.isPresent()) {
                throw new MasterException("نام برند تکراری است!");
            } else {

                weightUnitEntity.setTitle(weightUnitRequestDto.getTitle());
                weightUnitEntity.setUserCreate(user);
                weightUnitRepository.save(weightUnitEntity);
            }
            return ConvertEntityToDto.convertWeightUnitEntityToDto(weightUnitEntity);
        }
    }

    @Override
    public List<WeightUnitResponseDto> getAllWeightUnit() {
        return null;
    }

    @Override
    public WeightUnitResponseDto getWeightUnitById(Long id) {
        return null;
    }

    @Override
    public WeightUnitResponseDto editeWeightUnit(WeightUnitResponseDto weightUnitResponseDto, Long id) {
        return null;
    }

    @Override
    public void deleteWeightUnit(Long id) {

    }

    @Override
    public Page<WeightUnitResponseDto> getWeightUnitPagination(int offset, int pageSize) {
        return null;
    }
}
