package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.authentication.AuthRequest;
import com.rhpm.coffeeShop.authentication.AuthResponse;
import com.rhpm.coffeeShop.configs.JwtService;
import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserAuthRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.UserCompleteDataRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.UserRepository;
import com.rhpm.coffeeShop.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

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
                    .build());
            var jwtToken = jwtService.generateToken(userEntity);
            return AuthResponse.builder()
                    .token(jwtToken)
                    .build();
        }
    }

    @Override
    public AuthResponse loginUser(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public UserResponseDto completeUserInfo(UserCompleteDataRequestDto userCompleteDataRequestDto) throws IOException {
        UserEntity userEntity = userRepository.findById(userCompleteDataRequestDto.getUserId()).get();
        userRepository.save(UserEntity.builder()
                .phoneNumber(userCompleteDataRequestDto.getPhoneNumber())
                .nationalCode(userCompleteDataRequestDto.getNationalCode())
                .state(userCompleteDataRequestDto.getState())
                .city(userCompleteDataRequestDto.getCity())
                .address(userCompleteDataRequestDto.getAddress())
                .zipCode(userCompleteDataRequestDto.getZipCode())
                .profileImgUrl(ImageUtils.compressImage(userCompleteDataRequestDto.getFile().getBytes()))
                .profileImgName(UUID.randomUUID().toString())
                .build());
        return ConvertEntityToDto.convertUserEntityToDto(userEntity);
    }
}
