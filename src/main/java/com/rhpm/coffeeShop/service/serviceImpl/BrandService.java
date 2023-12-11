package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.entity.BrandEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.BrandRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import com.rhpm.coffeeShop.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandService implements com.rhpm.coffeeShop.service.BrandService {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    @Override
    public BrandResponseDto createBrand(BrandRequestDto brandRequestDto) throws MasterException, IOException {
        Optional<BrandEntity> brandEntity = brandRepository.findByBrandName(brandRequestDto.getBrandName());
        if (brandRequestDto.getBrandName().equals("") || brandRequestDto.getBrandAbout().equals("")) {
            throw new MasterException("فیلد ها نباید خالی باشند!");
        } else if (brandRequestDto.getBrandPic().isEmpty()) {
            throw new MasterException("لوگوی برند نباید خالی باشد!");
        } else if (brandRequestDto.getBrandName().length() > 60) {
            throw new MasterException("تعداد کارکتر برای اسم برند باید کمتر از 60 کاراکتر باشد!");
        } else if (brandEntity.isPresent()) {
            throw new MasterException("نام برند تکراری است!");
        } else {
            BrandEntity brand = new BrandEntity();
            UserEntity user = userRepository.findById(brandRequestDto.getUserCreateId())
                    .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
            brand.setBrandName(brandRequestDto.getBrandName());
            brand.setBrandAbout(brandRequestDto.getBrandAbout());
            brand.setBrandImgUrl(ImageUtils.compressImage(brandRequestDto.getBrandPic().getBytes()));
            brand.setUserCreated(user);
            brandRepository.save(brand);
            return ConvertEntityToDto.convertBrandEntityToDto(brand);
        }
    }
}
