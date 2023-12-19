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
        userResponseDto.setRole(user.getRole().name());
        userResponseDto.setIsActive(user.getIsActive());
        userResponseDto.setLastPurchase(user.getLastPurchase());
        userResponseDto.setLastEmailChange(user.getLastEmailChange());
        userResponseDto.setProfileImgName(user.getProfileImgName());
        userResponseDto.setRegisterDate(user.getRegisterDate());
        userResponseDto.setWalletId(user.getWallet().getId());
        userResponseDto.setIsActive(true);
        List<OldUserEmailResponseDto> oldUserEmailResponseDtos = user.getOldUserEmails().stream().map(oldUserEmailEntity -> {
            OldUserEmailResponseDto oldUserEmailResponseDto = new OldUserEmailResponseDto();
            oldUserEmailResponseDto.setId(oldUserEmailEntity.getId());
            oldUserEmailResponseDto.setOldEmail(oldUserEmailEntity.getOldEmail());
            oldUserEmailResponseDto.setNewEmail(oldUserEmailEntity.getNewEmail());
            oldUserEmailResponseDto.setUpdateAt(oldUserEmailEntity.getUpdateAt());
            oldUserEmailResponseDto.setUserId(oldUserEmailEntity.getUser().getId());
            return oldUserEmailResponseDto;
        }).toList();
        userResponseDto.setIncorrectLoginCount(userResponseDto.getIncorrectLoginCount());
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
        oldUserEmailResponseDto.setUpdateAt(oldUserEmailEntity.getUpdateAt());
        oldUserEmailResponseDto.setUserId(oldUserEmailEntity.getUser().getId());
        return oldUserEmailResponseDto;
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

    public static ProductResponseDto convertProductEntityToDto(ProductEntity product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setBrandId(product.getBrand().getId());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setWeight(product.getWeight());
        productResponseDto.setProductType(product.getProductType());
        List<TagResponseDto> tagResponseDtos = product.getTag().stream().map(tagEntity -> {
            TagResponseDto tagRes = new TagResponseDto();
            tagRes.setId(tagEntity.getId());
            tagRes.setTitle(tagEntity.getTitle());
            tagRes.setUserCreateId(tagEntity.getUserCreate().getId());
            tagRes.setCreateAt(tagEntity.getCreateAt());
            tagRes.setUpdateAt(tagEntity.getUpdateAt());
            return tagRes;
        }).toList();
        productResponseDto.setTag(tagResponseDtos);
        productResponseDto.setInventoryCount(product.getInventoryCount());
        productResponseDto.setProductImgUrl(product.getProductImgUrl());
        productResponseDto.setProductImgName(product.getProductImgName());
        productResponseDto.setIsEnable(product.getIsEnable());
        productResponseDto.setDiscount(product.getDiscount());
        productResponseDto.setLikeCount(product.getLikeCount());
        productResponseDto.setCommentCount(product.getCommentCount());
        productResponseDto.setUserCreatedId(product.getUserCreated().getId());
        productResponseDto.setViewCount(product.getViewCount());
        productResponseDto.setAdminView(product.getAdminView());
        productResponseDto.setCreated(product.getCreated());
        productResponseDto.setUpdated(product.getUpdated());
        productResponseDto.setSellCount(product.getSellCount());
        List<CategoryResponseDto> categoryResponseDtos = product.getCategory().stream().map(categoryEntity -> {
            CategoryResponseDto category = new CategoryResponseDto();
            category.setId(categoryEntity.getId());
            category.setTitle(categoryEntity.getTitle());
            category.setUserCreateId(categoryEntity.getUserCreateId().getId());
            category.setCreateAt(categoryEntity.getCreateAt());
            category.setUpdateAt(categoryEntity.getUpdateAt());
            return category;
        }).toList();
        productResponseDto.setCategory(categoryResponseDtos);
        productResponseDto.setWeightUnit(product.getWeightUnit().getTitle());
        return productResponseDto;
    }

    public static WeightUnitResponseDto convertWeightUnitEntityToDto(WeightUnitEntity weightUnitEntity) {
        WeightUnitResponseDto weightUnitResponseDto = new WeightUnitResponseDto();
        weightUnitResponseDto.setId(weightUnitEntity.getId());
        weightUnitResponseDto.setTitle(weightUnitEntity.getTitle());
        weightUnitResponseDto.setUserCreateId(weightUnitEntity.getUserCreate().getId());
        weightUnitResponseDto.setCreateAt(weightUnitEntity.getCreateAt());
        weightUnitResponseDto.setUpdateAt(weightUnitEntity.getUpdateAt());
        return weightUnitResponseDto;
    }

    public static CommentResponseDto convertCommentEntityToDto(CommentEntity comment) {
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setId(comment.getId());
        commentResponseDto.setBody(comment.getBody());
        commentResponseDto.setUserId(comment.getUserCreated().getId());
        return commentResponseDto;
    }

    public static WalletResponseDto convertWalletEntityToDto(WalletEntity wallet) {
        WalletResponseDto walletResponseDto = new WalletResponseDto();
        walletResponseDto.setId(wallet.getId());
        walletResponseDto.setBalance(wallet.getBalance());
        List<TransactionResponseDto> transactionResponseDtos = wallet.getTransaction().stream().map(transaction -> {
            TransactionResponseDto responseDto = new TransactionResponseDto();
            responseDto.setId(transaction.getId());
            responseDto.setAmount(transaction.getAmount());
            responseDto.setTransactionDate(transaction.getTransactionDate());
            responseDto.setWalletId(transaction.getWalletId());
            responseDto.setDescription(transaction.getDescription());
            return responseDto;
        }).toList();
        walletResponseDto.setTransaction(transactionResponseDtos);
        walletResponseDto.setUserId(walletResponseDto.getUserId());
        return walletResponseDto;
    }

    public static TransactionResponseDto convertTransactionEntityToDto(TransactionEntity transaction) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setId(transaction.getId());
        transactionResponseDto.setTransactionDate(transaction.getTransactionDate());
        transactionResponseDto.setAmount(transaction.getAmount());
        transactionResponseDto.setDescription(transaction.getDescription());
        transactionResponseDto.setWalletId(transaction.getWalletId());
        return transactionResponseDto;
    }
}
