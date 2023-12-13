package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.configs.JwtService;
import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.enums.Role;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.UserRepository;
import com.rhpm.coffeeShop.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements com.rhpm.coffeeShop.service.UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse createUser(UserAuthRequestDto userRequestDto) throws MasterException {
        Optional<UserEntity> user = userRepository.findByEmail(userRequestDto.getEmail());
        if (userRequestDto.getEmail().isEmpty() || userRequestDto.getFirstName().isEmpty() || userRequestDto.getLastName().isEmpty() || userRequestDto.getPassword().isEmpty()) {
            throw new MasterException("فیلد ها نباید خالی باشند!");
        } else if (user.isPresent()) {
            throw new MasterException("ایمیل وارد شده قبلا ثبت شده است!");
        } else if (userRequestDto.getEmail().length() > 320 || userRequestDto.getPassword().length() > 60) {
            throw new MasterException("تعداد کارکتر های وارد شده بیش از حد مجاز!");
        } else {
            UserEntity userEntity = userRepository.save(UserEntity.builder()
                    .firstName(userRequestDto.getFirstName())
                    .lastName(userRequestDto.getLastName())
                    .email(userRequestDto.getEmail())
                    .password(passwordEncoder.encode(userRequestDto.getPassword()))
                    .role(Role.ROLE_ADMIN)
                    .isActive(true)
                    .incorrectLoginCount((byte) 0)
                    .currentWalletBalance("0")
                    .emailConfirmation(false)
                    .phoneNumberConfirmation(false)
                    .isCompleteData(false)
                    .completeDataCount(0)
                    .CSID("_CS_" + UUID.randomUUID() + "_" + userRequestDto.getFirstName() + "_" + userRequestDto.getLastName())
                    .build());
            var jwtToken = jwtService.generateToken(userEntity);
            return AuthResponse.builder()
                    .token(jwtToken)
                    .build();
        }
    }

    @Override
    public AuthResponse loginUser(AuthRequest request) throws MasterException {
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new MasterException("کاربر پیدا نشد!")
        );
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var jwtToken = jwtService.generateToken(user);
            return AuthResponse.builder()
                    .token(jwtToken)
                    .build();
        }
    }

    @Override
    public UserResponseDto completeUserInfo(UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException, MasterException {
        UserEntity user = userRepository.findById(userCompleteDataRequestDto.getUserId())
                .orElseThrow(() -> new MasterException("کاربر مورد نظر یافت نشد!"));
        if (user.getIsActive()) {
            if (user.getIsCompleteData()) {
                user.setCity(userCompleteDataRequestDto.getCity());
                user.setAddress(userCompleteDataRequestDto.getAddress());
                user.setZipCode(userCompleteDataRequestDto.getZipCode());
                user.setProfileImgUrl(ImageUtils.compressImage(userCompleteDataRequestDto.getProfilePic().getBytes()));
                user.setProfileImgName(UUID.randomUUID().toString());
            } else {
                user.setPhoneNumber(userCompleteDataRequestDto.getPhoneNumber());
                user.setNationalCode(userCompleteDataRequestDto.getNationalCode());
                user.setState(userCompleteDataRequestDto.getState());
                user.setCity(userCompleteDataRequestDto.getCity());
                user.setAddress(userCompleteDataRequestDto.getAddress());
                user.setZipCode(userCompleteDataRequestDto.getZipCode());
                user.setProfileImgUrl(ImageUtils.compressImage(userCompleteDataRequestDto.getProfilePic().getBytes()));
                user.setProfileImgName(UUID.randomUUID().toString());
                user.setIsCompleteData(true);
                userRepository.save(user);
            }
        } else {
            throw new MasterException("حساب کاربری شما مسدود است!");
        }
        user.setCompleteDataCount(user.getCompleteDataCount() + 1);
        return ConvertEntityToDto.convertUserEntityToDto(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return ConvertEntityToDto.convertUserEntityToDto(user.get());
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(ConvertEntityToDto::convertUserEntityToDto).toList();
    }

    @Override
    public Page<UserResponseDto> getUserWithPagination(int offset, int pageSize) {
        Page<UserEntity> userEntities = userRepository.findAll(PageRequest.of(offset, pageSize));
        return userEntities.map(ConvertEntityToDto::convertUserEntityToDto);
    }

    @Override
    public byte[] getProfilePicUser(Long id) throws MasterException {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new MasterException("کاربر مورد نظر یافت نشد!"));
        return ImageUtils.decompressImage(userEntity.getProfileImgUrl());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
