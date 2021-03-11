package com.example.awesome_project.model;

public class UserForm extends LoginForm {
    public String fullName;

    public UserForm(String fullName,
                    String login,
                    String password) {
        super(login, password);
        this.fullName = fullName;
    }
}
