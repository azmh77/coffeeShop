package com.rhpm.coffeeShop.model.convertEntityToDto;

import com.rhpm.coffeeShop.model.dto.responseDto.*;
import com.rhpm.coffeeShop.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConvertEntityToDto {
    public static UserResponseDto convertUserEntityToDto(UserEntity user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setEmailConfirmation(true);
        userResponseDto.setPhoneNumber(user.getPhoneNumber());
        userResponseDto.setPhoneNumberConfirmation(true);
        userResponseDto.setNationalCode(user.getNationalCode());
        userResponseDto.setState(user.getState());
        userResponseDto.setCity(user.getCity());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setZipCode(user.getZipCode());
        userResponseDto.setCurrentWalletBalance(user.getCurrentWalletBalance());
        userResponseDto.setRole(user.getRole().name());
        userResponseDto.setIsActive(user.getIsActive());
        userResponseDto.setLastPurchase(user.getLastPurchase());
        userResponseDto.setLastPasswordChange(user.getLastPasswordChange());
        userResponseDto.setLastEmailChange(user.getLastEmailChange());
        userResponseDto.setProfileImgName(user.getProfileImgName());
        userResponseDto.setRegisterDate(user.getRegisterDate());
        userResponseDto.setIsActive(true);
        List<OldUserPasswordResponseDto> oldUserPasswordResponseDtos = user.getOldUserPasswords().stream().map(oldUserPasswordEntity -> {
            OldUserPasswordResponseDto oldUserPasswordResponseDto = new OldUserPasswordResponseDto();
            oldUserPasswordResponseDto.setId(oldUserPasswordEntity.getId());
            oldUserPasswordResponseDto.setOldPassword(oldUserPasswordEntity.getOldPassword());
            oldUserPasswordResponseDto.setNewPassword(oldUserPasswordEntity.getNewPassword());
            oldUserPasswordResponseDto.setPasswordChangeDate(oldUserPasswordEntity.getPasswordChangeDate());
            oldUserPasswordResponseDto.setUserId(oldUserPasswordEntity.getUser().getId());
            return oldUserPasswordResponseDto;
        }).toList();
        userResponseDto.setOldUserPasswords(oldUserPasswordResponseDtos);
        List<OldUserEmailResponseDto> oldUserEmailResponseDtos = user.getOldUserEmails().stream().map(oldUserEmailEntity -> {
            OldUserEmailResponseDto oldUserEmailResponseDto = new OldUserEmailResponseDto();
            oldUserEmailResponseDto.setId(oldUserEmailEntity.getId());
            oldUserEmailResponseDto.setOldEmail(oldUserEmailEntity.getOldEmail());
            oldUserEmailResponseDto.setNewEmail(oldUserEmailEntity.getNewEmail());
            oldUserEmailResponseDto.setEmailChangeDate(oldUserEmailEntity.getEmailChangeDate());
            oldUserEmailResponseDto.setUserId(oldUserEmailEntity.getUser().getId());
            return oldUserEmailResponseDto;
        }).toList();
        userResponseDto.setOldUserEmails(oldUserEmailResponseDtos);
        userResponseDto.setIncorrectLoginCount(user.getIncorrectLoginCount());
        userResponseDto.setProfileImgUrl(user.getProfileImgUrl());
        userResponseDto.setProfileImgUrl(user.getProfileImgUrl());
        userResponseDto.setCSID(user.getCSID());
        return userResponseDto;
    }

    public static OldUserEmailResponseDto convertOldUerEmailEntityToDto(OldUserEmailEntity oldUserEmailEntity) {
        OldUserEmailResponseDto oldUserEmailResponseDto = new OldUserEmailResponseDto();
        oldUserEmailResponseDto.setId(oldUserEmailEntity.getId());
        oldUserEmailResponseDto.setOldEmail(oldUserEmailEntity.getOldEmail());
        oldUserEmailResponseDto.setNewEmail(oldUserEmailEntity.getNewEmail());
        oldUserEmailResponseDto.setEmailChangeDate(oldUserEmailEntity.getEmailChangeDate());
        oldUserEmailResponseDto.setUserId(oldUserEmailEntity.getUser().getId());
        return oldUserEmailResponseDto;
    }

    public static OldUserPasswordResponseDto convertOldUserPasswordEntityToDto(OldUserPasswordEntity oldUserPasswordEntity) {
        OldUserPasswordResponseDto oldUserPasswordResponseDto = new OldUserPasswordResponseDto();
        oldUserPasswordResponseDto.setId(oldUserPasswordEntity.getId());
        oldUserPasswordResponseDto.setOldPassword(oldUserPasswordEntity.getOldPassword());
        oldUserPasswordResponseDto.setNewPassword(oldUserPasswordEntity.getNewPassword());
        oldUserPasswordResponseDto.setPasswordChangeDate(oldUserPasswordEntity.getPasswordChangeDate());
        oldUserPasswordResponseDto.setUserId(oldUserPasswordEntity.getUser().getId());
        return oldUserPasswordResponseDto;
    }

    public static BrandResponseDto convertBrandEntityToDto(BrandEntity brand) {
        BrandResponseDto brandResponseDto = new BrandResponseDto();
        brandResponseDto.setId(brand.getId());
        brandResponseDto.setBrandName(brand.getBrandName());
        brandResponseDto.setBrandAbout(brand.getBrandAbout());
        brandResponseDto.setBrandImgUrl(brand.getBrandImgUrl());
        brandResponseDto.setBrandImgName(UUID.randomUUID().toString());
        brandResponseDto.setUserCreateId(brand.getUserCreated().getId());
        return brandResponseDto;
    }

    public static CategoryResponseDto convertCategoryEntityToDto(CategoryEntity category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setTitle(category.getTitle());
        categoryResponseDto.setUserCreateId(category.getUserCreateId().getId());
        categoryResponseDto.setCreateAt(category.getCreateAt());
        categoryResponseDto.setUpdateAt(category.getUpdateAt());
        return categoryResponseDto;
    }

    public static DiscountResponseDto convertDiscountEntityToDto(DiscountEntity discount) {
        DiscountResponseDto discountResponseDto = new DiscountResponseDto();
        discountResponseDto.setId(discount.getId());
        discountResponseDto.setCode(discount.getCode());
        discountResponseDto.setUserCreateId(discount.getUserCreate().getId());
        discountResponseDto.setCreateAt(discount.getCreateAt());
        discountResponseDto.setUpdateAt(discount.getUpdateAt());
        return discountResponseDto;
    }

    public static TagResponseDto convertTagEntityToDto(TagEntity tag) {
        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setId(tag.getId());
        tagResponseDto.setTitle(tag.getTitle());
        tagResponseDto.setUserCreateId(tag.getUserCreate().getId());
        tagResponseDto.setCreateAt(tag.getCreateAt());
        tagResponseDto.setUpdateAt(tag.getUpdateAt());
        return tagResponseDto;
    }
}
