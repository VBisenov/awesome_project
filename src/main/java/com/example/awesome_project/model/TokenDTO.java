package com.example.awesome_project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "token")
public class TokenDTO {
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    public User user;
    public String token;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public TokenDTO(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public TokenDTO() {
    }
}
