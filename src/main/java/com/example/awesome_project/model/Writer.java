package com.example.awesome_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Writer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private Date birthDate;
    private Date deathDate;

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                '}';
    }
}
