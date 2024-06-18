package com.bosch.example.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bosch.example.dto.Password;
import com.bosch.example.services.PasswordService;

public class ImplPasswordService implements PasswordService{

    @Override
    public Boolean verifyPassword(Password pass) {
        String password = pass.newPassword();

        if(password.length() < 8) {
            return false;
        }

        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);

        if (!specialCharMatcher.find()) {
            return false;
        }

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);

        if (!uppercaseMatcher.find()) {
            return false;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        
        if (!digitMatcher.find()) {
            return false;
        }

        return true;
    }
    
}
