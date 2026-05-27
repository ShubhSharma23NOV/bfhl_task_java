package com.acropolis.bfhl.service;

import com.acropolis.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {
    
    // Constants - Mock data for demonstration
    private static final String USER_ID = "shubh_sharma_23112005";
    private static final String EMAIL = "shubhsharma231358@acropolis.in";
    private static final String ROLL_NUMBER = "0827CY231066";
    
    @Override
    public BfhlResponse processData(List<String> data) {
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        List<String> originalAlphabets = new ArrayList<>(); // Keep original case for concat_string
        
        int totalSum = 0;
        
        for (String element : data) {
            if (isNumber(element)) {
                int num = Integer.parseInt(element);
                totalSum += num;
                
                if (num % 2 == 0) {
                    evenNumbers.add(element);
                } else {
                    oddNumbers.add(element);
                }
            } else if (isAlphabetic(element)) {
                alphabets.add(element.toUpperCase());
                originalAlphabets.add(element); // Store original case
            } else {
                specialCharacters.add(element);
            }
        }
        
        String concatString = buildConcatString(originalAlphabets);
        
        return BfhlResponse.builder()
                .isSuccess(true)
                .userId(USER_ID)
                .email(EMAIL)
                .rollNumber(ROLL_NUMBER)
                .oddNumbers(oddNumbers)
                .evenNumbers(evenNumbers)
                .alphabets(alphabets)
                .specialCharacters(specialCharacters)
                .sum(String.valueOf(totalSum))
                .concatString(concatString)
                .build();
    }
    
    private boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isAlphabetic(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return s.matches("[a-zA-Z]+");
    }
    
    private String buildConcatString(List<String> alphabeticElements) {
        if (alphabeticElements.isEmpty()) {
            return "";
        }
        
        // Step 1: Extract all alphabetic characters from every alphabetic element
        StringBuilder allChars = new StringBuilder();
        for (String element : alphabeticElements) {
            // Use original case elements to extract individual characters
            for (char c : element.toCharArray()) {
                allChars.append(c);
            }
        }
        
        // Step 2: Concatenate them into a single string (already done above)
        String concatenated = allChars.toString();
        
        // Step 3: Reverse the entire concatenated string
        String reversed = new StringBuilder(concatenated).reverse().toString();
        
        // Step 4: Apply alternating case starting with UPPERCASE
        return applyAlternatingCaps(reversed);
    }
    
    private String applyAlternatingCaps(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i % 2 == 0) {
                // Even index (0, 2, 4, ...) -> uppercase
                result.append(Character.toUpperCase(c));
            } else {
                // Odd index (1, 3, 5, ...) -> lowercase
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}