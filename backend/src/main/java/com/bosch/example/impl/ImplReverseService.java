package com.bosch.example.impl;

import com.bosch.example.dto.Word;
import com.bosch.example.services.ReverseService;

public class ImplReverseService implements ReverseService {

    @Override
    public Word wordReverse(String word) {
        StringBuilder result = new StringBuilder();
        Boolean palindrome = true;
        
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (Character.isLetterOrDigit(c)) { 
                result.append(c); 
                if (Character.toLowerCase(c) != Character.toLowerCase(word.charAt(word.length() - 1 - i))) {
                    palindrome = false; 
                }
            }
        }
        
        if (!palindrome) {
            palindrome = false;
        }

        return new Word(result.toString(), palindrome); 
    }
}
