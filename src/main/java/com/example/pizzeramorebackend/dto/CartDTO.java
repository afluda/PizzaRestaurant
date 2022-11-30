package com.example.pizzeramorebackend.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDTO {
    @NotEmpty
    private List<CartElementDTO> cartElement = new ArrayList<>();
    @NotEmpty
    private OrderDTO order;
}
