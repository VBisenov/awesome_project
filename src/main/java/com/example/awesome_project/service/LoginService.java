package com.example.awesome_project.service;

import com.example.awesome_project.exceptions.UserAlreadyExistException;
import com.example.awesome_project.exceptions.UserDoesNotExistException;
import com.example.awesome_project.model.LoginForm;
import com.example.awesome_project.model.TokenDTO;
import com.example.awesome_project.model.User;
import com.example.awesome_project.model.UserForm;
import com.example.awesome_project.repository.TokenRepository;
import com.example.awesome_project.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    @Autowired
    public LoginService(UserRepository userRepository,
                        TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public boolean register(UserForm userForm) throws NullPointerException, UserAlreadyExistException {
        if (userForm.login == null || userForm.fullName == null || userForm.password == null)
            throw new NullPointerException("userFrom contain null fields!");
        User user = userRepository.findUserByFullNameAndLogin(userForm.fullName, userForm.login);
        if (user != null) {
            throw new UserAlreadyExistException("User " + user.getFullName() + " already exist!");
        }
        userRepository.save(
                new User(userForm.fullName, userForm.login, userForm.password));
        return true;
    }

    public String login(LoginForm loginForm) throws NullPointerException, UserDoesNotExistException {
        TokenDTO tokenDTO;
        if (loginForm.login == null || loginForm.password == null)
            throw new NullPointerException("loginForm contain null fields!");
        User user = userRepository.findUserByLoginAndPassword(loginForm.login, loginForm.password);
        if (user == null) {
            throw new UserDoesNotExistException("User with login " + loginForm.login + " does not exist");
        } else {
            tokenDTO = tokenRepository.getTokenDTOByUserId(user.getId());
            if (tokenDTO == null) {
                tokenDTO = new TokenDTO(user, RandomString.make(10));
                tokenRepository.save(tokenDTO);
            }
        }
        //todo return only token
        return tokenDTO.token;
    }

}
