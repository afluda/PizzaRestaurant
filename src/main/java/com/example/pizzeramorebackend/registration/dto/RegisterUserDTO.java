package com.example.pizzeramorebackend.registration.dto;

import com.example.pizzeramorebackend.models.enums.Role;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegisterUserDTO {
    @Email
    @NotBlank(message = "email is blank")
    private final String email;
    @NotBlank(message = "password is blank")
    @Min(4)
    private final String password;
    @NotEmpty
    private final Set<Role> roles;
}
