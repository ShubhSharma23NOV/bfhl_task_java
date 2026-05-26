package com.acropolis.bfhl.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BfhlRequest {
    
    @NotNull(message = "data field must not be null")
    @NotEmpty(message = "data array must not be empty")
    private List<String> data;
}