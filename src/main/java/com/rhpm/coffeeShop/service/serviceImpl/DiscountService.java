package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.entity.DiscountEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.DiscountRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DiscountService implements com.rhpm.coffeeShop.service.DiscountService {
    private final DiscountRepository discountRepository;
    private final UserRepository userRepository;

    @Override
    public DiscountResponseDto createDiscount(DiscountRequestDto discountRequestDto) throws MasterException, IOException {
        Optional<DiscountEntity> discountEntity = discountRepository.findByCode(discountRequestDto.getCode());
        DiscountEntity discount = new DiscountEntity();
        UserEntity user = userRepository.findById(discountRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (discountRequestDto.getCode().isEmpty()) {
                throw new MasterException("فیلد ها نباید خالی باشند!");
            } else if (discountRequestDto.getCode().length() > 24) {
                throw new MasterException("طول کد تخفیف بیش از حد مجاز!");
            } else if (discountEntity.isPresent()) {
                throw new MasterException("کد تخفیف تکراری است!");
            } else {
                discount.setCode(discountRequestDto.getCode());
                discount.setUserCreate(user);
                discountRepository.save(discount);
            }
            return ConvertEntityToDto.convertDiscountEntityToDto(discount);
        }
    }

    @Override
    public List<DiscountResponseDto> getAllDiscount() {
        return null;
    }

    @Override
    public DiscountResponseDto getDiscountById(Long id) {
        return null;
    }

    @Override
    public DiscountResponseDto editeDiscount(DiscountRequestDto discountRequestDto, Long id) {
        return null;
    }

    @Override
    public void deleteDiscount(Long id) {

    }

    @Override
    public Page<DiscountResponseDto> getDiscountWithPagination(int offset, int pageSize) {
        return null;
    }
}
