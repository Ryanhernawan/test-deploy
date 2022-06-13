package com.alterra.MiniProjectRyanHernawan.repository;

import com.alterra.MiniProjectRyanHernawan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;

@Repository
@EnableWebSecurity
public interface UserRepository extends JpaRepository<User, Long> {
    User getDistinctTopByUsername(String username);
}
