package com.example.awesome_project.repository;

import com.example.awesome_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByFullNameAndLogin(String fullName, String login);

    User findUserByLoginAndPassword(String login, String password);
}
