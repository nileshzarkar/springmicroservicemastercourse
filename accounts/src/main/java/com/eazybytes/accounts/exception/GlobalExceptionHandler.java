package com.eazybytes.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerAlreadyException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyException(CustomerAlreadyException exception,
                                        WebRequest webRequest) 
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false), 
            HttpStatus.BAD_REQUEST, 
            exception.getMessage(), 
            LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);        
    }

}
