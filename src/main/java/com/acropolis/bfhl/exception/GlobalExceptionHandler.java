package com.acropolis.bfhl.exception;

import com.acropolis.bfhl.dto.BfhlResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BfhlResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        
        BfhlResponse response = BfhlResponse.builder()
                .isSuccess(false)
                .message(errorMessage)
                .oddNumbers(List.of())
                .evenNumbers(List.of())
                .alphabets(List.of())
                .specialCharacters(List.of())
                .sum("0")
                .concatString("")
                .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BfhlResponse> handleMalformedJsonException(HttpMessageNotReadableException ex) {
        BfhlResponse response = BfhlResponse.builder()
                .isSuccess(false)
                .message("Malformed JSON request")
                .oddNumbers(List.of())
                .evenNumbers(List.of())
                .alphabets(List.of())
                .specialCharacters(List.of())
                .sum("0")
                .concatString("")
                .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponse> handleGenericException(Exception ex) {
        BfhlResponse response = BfhlResponse.builder()
                .isSuccess(false)
                .message("Internal server error: " + ex.getMessage())
                .oddNumbers(List.of())
                .evenNumbers(List.of())
                .alphabets(List.of())
                .specialCharacters(List.of())
                .sum("0")
                .concatString("")
                .build();
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}