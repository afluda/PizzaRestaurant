package com.example.pizzeramorebackend.utils;

import com.example.pizzeramorebackend.dto.ErrorMessageDTO;
import com.example.pizzeramorebackend.exceptions.EmailInUseException;
import com.example.pizzeramorebackend.exceptions.MealNotFoundException;
import com.example.pizzeramorebackend.exceptions.PasswordNotCorrectException;
import com.example.pizzeramorebackend.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorHandler {

    @Order(0)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorMessageDTO> defaultExceptions(Throwable ex) {
        log.error(ex.toString());
        return createResponseEntity(
                new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR, "An unknown error occurred.", new Date())
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleUserNotFoundException(UserNotFoundException ex) {
        return createResponseEntity(
                ErrorMessageDTO.builder()
                        .message(ex.getMessage())
                        .timestamp(new Date())
                        .status(HttpStatus.NOT_FOUND).build()
        );
    }

    @ExceptionHandler(MealNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleMealNotFoundException(MealNotFoundException ex) {
        return createResponseEntity(
                ErrorMessageDTO.builder()
                        .message(ex.getMessage())
                        .timestamp(new Date())
                        .status(HttpStatus.NOT_FOUND).build()
        );
    }

    @ExceptionHandler(EmailInUseException.class)
    public ResponseEntity<ErrorMessageDTO> handlePasswordNotCorrectException(EmailInUseException ex) {
        return createResponseEntity(
                ErrorMessageDTO.builder()
                        .message(ex.getMessage())
                        .timestamp(new Date())
                        .status(HttpStatus.NOT_FOUND).build()
        );
    }

    @ExceptionHandler(PasswordNotCorrectException.class)
    public ResponseEntity<ErrorMessageDTO> handleEmailInUseException(PasswordNotCorrectException ex) {
        return createResponseEntity(
                ErrorMessageDTO.builder()
                        .message(ex.getMessage())
                        .timestamp(new Date())
                        .status(HttpStatus.NOT_FOUND).build()
        );
    }

    private ResponseEntity<ErrorMessageDTO> createResponseEntity(ErrorMessageDTO errorMessageDTO) {
        return ResponseEntity.status(errorMessageDTO.getStatus()).body(errorMessageDTO);
    }

}
