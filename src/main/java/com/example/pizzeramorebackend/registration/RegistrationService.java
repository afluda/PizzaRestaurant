package com.example.pizzeramorebackend.registration;

import com.example.pizzeramorebackend.exceptions.EmailInUseException;
import com.example.pizzeramorebackend.mapper.UserMapper;
import com.example.pizzeramorebackend.models.User;
import com.example.pizzeramorebackend.models.enums.Role;
import com.example.pizzeramorebackend.registration.dto.RegisterUserDTO;
import com.example.pizzeramorebackend.registration.dto.RegistrationRequest;
import com.example.pizzeramorebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;


    public RegisterUserDTO register(RegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailInUseException(request.getEmail());
        }
        User user = userRepository.save(buildUser(request.getEmail(), request.getPassword()));
        return userMapper.toRegisterUserDTO(user);
    }

    private User buildUser(String email, String password) {
        return User.builder()
                .email(email)
                .password(bCryptPasswordEncoder.encode(password))
                .roles(Set.of(Role.ROLE_USER))
                .build();
    }
}
