package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User extends Student {
    private String login;
    private String password;

    public User(String fullName, String login, String password) {
        super(fullName);
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public User() {

    }
}
