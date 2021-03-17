package com.example.awesome_project.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "token")
public class TokenDTO {
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public User user;
    public String token;
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    public TokenDTO(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public TokenDTO() {
    }
}
