package com.example.pizzeramorebackend.registration;

import com.example.pizzeramorebackend.registration.dto.RegisterUserDTO;
import com.example.pizzeramorebackend.registration.dto.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<RegisterUserDTO> register(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.status(201).body(registrationService.register(request));
    }
}
