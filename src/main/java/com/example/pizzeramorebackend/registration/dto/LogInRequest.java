package com.example.pizzeramorebackend.registration.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class LogInRequest {
    @Email
    @NotBlank(message = "email is blank")
    private final String email;
    @NotBlank(message = "password is blank")
    @Min(4)
    private final String password;
}
