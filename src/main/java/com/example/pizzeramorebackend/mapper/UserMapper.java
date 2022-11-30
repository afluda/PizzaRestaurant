package com.example.pizzeramorebackend.mapper;

import com.example.pizzeramorebackend.dto.UserDTO.UserDTO;
import com.example.pizzeramorebackend.models.User;
import com.example.pizzeramorebackend.registration.dto.LogInRequest;
import com.example.pizzeramorebackend.registration.dto.RegisterUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderList", ignore = true)
    @Mapping(target = "password", ignore = true)
    User fromDTO(UserDTO clientDTO);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "street", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "orderList", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User fromRegisterMapper(RegisterUserDTO registerUserDTO);


    RegisterUserDTO toRegisterUserDTO(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "street", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "orderList", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User fromLogInRequest(LogInRequest request);


    LogInRequest toLogInRequest(User user);


}
