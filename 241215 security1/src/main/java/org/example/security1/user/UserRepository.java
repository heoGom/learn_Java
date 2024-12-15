package org.example.security1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    //findBy규칙 -> Username문법
    //select * from user where username = ?
    public User findByUsername(String username);  // Jpa Query method
}
