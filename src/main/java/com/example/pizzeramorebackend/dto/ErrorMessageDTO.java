package com.example.pizzeramorebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorMessageDTO {
    private HttpStatus status;
    private String message;
    private Date timestamp;

}
