package com.example.awesome_project.exceptions;

public class UserDoesNotExistException extends Throwable {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
