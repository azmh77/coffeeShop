package com.rhpm.coffeeShop.model.convertEntityToDto;

import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.OldUserEmailResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.OldUserPasswordResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.entity.BrandEntity;
import com.rhpm.coffeeShop.model.entity.OldUserEmailEntity;
import com.rhpm.coffeeShop.model.entity.OldUserPasswordEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
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
}
