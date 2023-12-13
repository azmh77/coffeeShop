package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.model.entity.BrandEntity;
import com.rhpm.coffeeShop.model.entity.TagEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.TagRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagService implements com.rhpm.coffeeShop.service.TagService {
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    @Override
    public TagResponseDto createTag(TagRequestDto tagRequestDto) throws MasterException, IOException {
        Optional<TagEntity> tagEntity = tagRepository.findByTitle(tagRequestDto.getTitle());
        TagEntity tag = new TagEntity();
        UserEntity user = userRepository.findById(tagRequestDto.getUserCreateId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (tagRequestDto.getTitle().isEmpty()) {
                throw new MasterException("فیلد ها نباید خالی باشند!");
            } else if (tagRequestDto.getTitle().length() > 120) {
                throw new MasterException("طول تگ بیش از حد مجاز!");
            } else if (tagEntity.isPresent()) {
                throw new MasterException("تگ تکراری است!");
            } else {
                tag.setTitle(tagRequestDto.getTitle());
                tag.setUserCreate(user);
                tagRepository.save(tag);
            }
            return ConvertEntityToDto.convertTagEntityToDto(tag);
        }
    }

    @Override
    public List<TagResponseDto> getAllTags() {
        return null;
    }

    @Override
    public TagResponseDto getTagsById(Long id) {
        return null;
    }

    @Override
    public TagResponseDto editeTags(TagResponseDto tagResponseDto, Long id) {
        return null;
    }

    @Override
    public void deleteTags(Long id) {

    }

    @Override
    public Page<TagResponseDto> getTagsWithPagination(int offset, int pageSize) {
        return null;
    }
}
