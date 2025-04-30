package com.Amarachi._DaysChallenge.api.repository;



import com.Amarachi._DaysChallenge.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

