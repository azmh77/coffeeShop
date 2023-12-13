package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.entity.BrandEntity;
import com.rhpm.coffeeShop.model.entity.CategoryEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.CategoryRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements com.rhpm.coffeeShop.service.CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) throws MasterException {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findByTitle(categoryRequestDto.getTitle());
        CategoryEntity category = new CategoryEntity();
        UserEntity user = userRepository.findById(categoryRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (categoryRequestDto.getTitle().isEmpty()) {
                throw new MasterException("فیلد ها نباید خالی باشند!");
            } else if (categoryRequestDto.getTitle().length() > 60) {
                throw new MasterException("تعداد کارکتر برای اسم دسته بندی باید کمتر از 60 کاراکتر باشد!");
            } else if (categoryEntity.isPresent()) {
                throw new MasterException("نام دسته بندی تکراری است!");
            } else {

                category.setTitle(categoryRequestDto.getTitle());
                category.setUserCreateId(user);
                categoryRepository.save(category);
            }
            return ConvertEntityToDto.convertCategoryEntityToDto(category);
        }
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<CategoryEntity> users = categoryRepository.findAll();
        return users.stream().map(ConvertEntityToDto::convertCategoryEntityToDto).toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        return ConvertEntityToDto.convertCategoryEntityToDto(category.get());
    }

    @Override
    public CategoryResponseDto editeCategory(CategoryRequestDto categoryRequestDto, Long id) throws MasterException {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new MasterException("دسته بندی با این آیدی وحود ندارد!"));
        UserEntity user = userRepository.findById(categoryRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            category.setTitle(categoryRequestDto.getTitle());
            category.setUserCreateId(user);
        }
        return ConvertEntityToDto.convertCategoryEntityToDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<CategoryResponseDto> getCategoryWithPagination(int offset, int pageSize) {
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(PageRequest.of(offset, pageSize));
        return categoryEntities.map(ConvertEntityToDto::convertCategoryEntityToDto);
    }
}
