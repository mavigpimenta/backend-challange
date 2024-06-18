package com.bosch.example.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

public class DatabaseUserService implements UserService {
    @Autowired
    UserJPARepository repo;

    @Override
    public Boolean verifyUser(User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        if (repo.findByUsername(username).size() > 0 || repo.findByEmail(email).size() > 0) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean verifyPassword(User user) {
        String password = user.getPassword();
        
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

    @Override
    public Boolean verifyEmail(User user) {
        String email = user.getEmail();
        String email_regex = "^([\\w\\.-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$";

        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public List<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

}
