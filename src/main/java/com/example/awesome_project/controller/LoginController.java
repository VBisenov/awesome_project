package com.example.awesome_project.controller;

import com.example.awesome_project.exceptions.UserAlreadyExistException;
import com.example.awesome_project.exceptions.UserDoesNotExistException;
import com.example.awesome_project.model.LoginForm;
import com.example.awesome_project.model.TokenDTO;
import com.example.awesome_project.model.UserForm;
import com.example.awesome_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(
            @RequestBody UserForm userForm
    ) {
        try {
            loginService.register(userForm);
            return ResponseEntity.ok("User "+ userForm.fullName +" created");
        } catch (UserAlreadyExistException ex) {
            return new ResponseEntity<>("User already exist", HttpStatus.CONFLICT);
        } catch (NullPointerException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginForm loginForm
    ) {
        try {
            return ResponseEntity.ok(loginService.login(loginForm));
        } catch (UserDoesNotExistException ex) {
            return new ResponseEntity<>("User does not exist or cannot be accessed", HttpStatus.FORBIDDEN);
        } catch (NullPointerException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(
            @RequestParam(name = "userId")
                    UUID userId) {
        try {
            return ResponseEntity.ok(loginService.logout(userId));
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
