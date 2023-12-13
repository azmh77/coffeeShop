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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService implements com.rhpm.coffeeShop.service.BrandService {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;

    @Override
    public BrandResponseDto createBrand(BrandRequestDto brandRequestDto) throws MasterException, IOException {
        Optional<BrandEntity> brandEntity = brandRepository.findByBrandName(brandRequestDto.getBrandName());
        BrandEntity brand = new BrandEntity();
        UserEntity user = userRepository.findById(brandRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (brandRequestDto.getBrandName().isEmpty() || brandRequestDto.getBrandAbout().isEmpty()) {
                throw new MasterException("فیلد ها نباید خالی باشند!");
            } else if (brandRequestDto.getBrandPic().isEmpty()) {
                throw new MasterException("لوگوی برند نباید خالی باشد!");
            } else if (brandRequestDto.getBrandName().length() > 60) {
                throw new MasterException("تعداد کارکتر برای اسم برند باید کمتر از 60 کاراکتر باشد!");
            } else if (brandEntity.isPresent()) {
                throw new MasterException("نام برند تکراری است!");
            } else {
                brand.setBrandName(brandRequestDto.getBrandName());
                brand.setBrandAbout(brandRequestDto.getBrandAbout());
                brand.setBrandImgUrl(ImageUtils.compressImage(brandRequestDto.getBrandPic().getBytes()));
                brand.setUserCreated(user);
                brandRepository.save(brand);

            }
        }
        return ConvertEntityToDto.convertBrandEntityToDto(brand);
    }

    @Override
    public List<BrandResponseDto> getAllBrand() {
        List<BrandEntity> users = brandRepository.findAll();
        return users.stream().map(ConvertEntityToDto::convertBrandEntityToDto).toList();
    }

    @Override
    public BrandResponseDto getBrandById(Long id) {
        Optional<BrandEntity> brand = brandRepository.findById(id);
        return ConvertEntityToDto.convertBrandEntityToDto(brand.get());
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandResponseDto editeBrand(BrandRequestDto brandRequestDto, Long id) throws MasterException, IOException {
        BrandEntity brand = brandRepository.findById(id)
                .orElseThrow(() -> new MasterException("برندی با این آیدی وحود ندارد!"));
        UserEntity user = userRepository.findById(brandRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            brand.setBrandName(brandRequestDto.getBrandName());
            brand.setBrandAbout(brandRequestDto.getBrandAbout());
            brand.setBrandImgUrl(brandRequestDto.getBrandPic().getBytes());
            brand.setUserCreated(user);
            brandRepository.save(brand);
        }
        return ConvertEntityToDto.convertBrandEntityToDto(brand);
    }

    @Override
    public Page<BrandResponseDto> getBrandWithPagination(int offset, int pageSize) {
        Page<BrandEntity> brandEntities = brandRepository.findAll(PageRequest.of(offset, pageSize));
        return brandEntities.map(ConvertEntityToDto::convertBrandEntityToDto);
    }
}
