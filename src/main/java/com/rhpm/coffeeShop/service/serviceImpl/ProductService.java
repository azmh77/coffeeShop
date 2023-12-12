package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;
import com.rhpm.coffeeShop.model.entity.*;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.*;
import com.rhpm.coffeeShop.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class ProductService implements com.rhpm.coffeeShop.service.ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final DiscountRepository discountRepository;
    private final UserRepository userRepository;
    private final WeightUnitRepository weightUnitRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) throws MasterException, IOException {
        if (productRequestDto.getTitle().isEmpty() || productRequestDto.getDescription().isEmpty()
                || productRequestDto.getPrice().isEmpty() || productRequestDto.getProductType().isEmpty()) {
            throw new MasterException("فیلد ها نباید خالی باشند!");

        } else if (productRequestDto.getWeight().equals(0L) || productRequestDto.getInventoryCount().equals(0L)) {
            throw new MasterException("وزن یا مقدار اولیه محصول نباید صفر باشد!");
        } else {
            ProductEntity product = new ProductEntity();
            BrandEntity brand = brandRepository.findById(productRequestDto.getBrandId())
                    .orElseThrow(() -> new MasterException("برند مورد نطر یافت نشد!"));
            List<TagEntity> tags = productRequestDto.getTag();
            UserEntity user = userRepository.findById(productRequestDto.getUserCreatedId()).orElseThrow(
                    () -> new MasterException("کاربر پیدا نشد!")
            );
            List<CategoryEntity> categorys = productRequestDto.getCategory();
            WeightUnitEntity weightUnit = weightUnitRepository.findById(productRequestDto.getWeightUnitId())
                    .orElseThrow(() -> new MasterException("واحد وزن تعریف نشده است!"));
            product.setTitle(productRequestDto.getTitle());
            product.setDescription(productRequestDto.getDescription());
            product.setBrand(brand);
            product.setPrice(productRequestDto.getPrice());
            product.setWeight(productRequestDto.getWeight());
            product.setProductType(productRequestDto.getProductType());
            product.setTag(tags);
            product.setInventoryCount(productRequestDto.getInventoryCount());
            product.setDiscount(productRequestDto.getDiscount());
            product.setUserCreated(user);
            product.setCategory(categorys);
            product.setProductImgUrl(ImageUtils.compressImage(productRequestDto.getProfilePic().getBytes()));
            product.setProductImgName(UUID.randomUUID().toString());
            product.setIsEnable(true);
            product.setLikeCount(0L);
            product.setCommentCount(0L);
            product.setSellCount(0L);
            product.setAdminView(false);
            product.setViewCount(0L);
            product.setWeightUnit(weightUnit);
            productRepository.save(product);
            return ConvertEntityToDto.convertProductEntityToDto(product);
        }
    }

    @Override
    public ProductResponseDto getProductById(Long id) throws MasterException {
        Optional<ProductEntity> user = productRepository.findById(id);
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new MasterException("محصولی وجود ندارد!"));
        product.setViewCount(product.getViewCount() + 1);
        productRepository.save(product);
        return ConvertEntityToDto.convertProductEntityToDto(user.get());
    }
}

