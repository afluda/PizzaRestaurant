package com.example.pizzeramorebackend.dto.UserDTO;

import com.example.pizzeramorebackend.models.enums.Role;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private Set<Role> roles;
}
