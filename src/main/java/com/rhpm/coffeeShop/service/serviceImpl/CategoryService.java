package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.entity.CategoryEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.CategoryRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements com.rhpm.coffeeShop.service.CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) throws MasterException {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findByTitle(categoryRequestDto.getTitle());
        if (categoryRequestDto.getTitle().equals("")) {
            throw new MasterException("فیلد ها نباید خالی باشند!");
        } else if (categoryRequestDto.getTitle().length() > 60) {
            throw new MasterException("تعداد کارکتر برای اسم دسته بندی باید کمتر از 60 کاراکتر باشد!");
        } else if (categoryEntity.isPresent()) {
            throw new MasterException("نام دسته بندی تکراری است!");
        } else {
            CategoryEntity category = new CategoryEntity();
            UserEntity user = userRepository.findById(categoryRequestDto.getUserCreateId())
                    .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
            category.setTitle(categoryRequestDto.getTitle());
            category.setUserCreateId(user);
            categoryRepository.save(category);
            return ConvertEntityToDto.convertCategoryEntityToDto(category);
        }
    }
}
