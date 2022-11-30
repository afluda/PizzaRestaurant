package com.example.pizzeramorebackend.dto;


import com.example.pizzeramorebackend.dto.UserDTO.UserDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    @NotEmpty
    private UserDTO user;
    @NotEmpty
    private Date date;
    @NotEmpty
    private CartDTO cart;
}
