package com.pawsitivity.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawsitivity.server.model.UserAccEntity;

@Repository
public interface UserRepository extends JpaRepository<UserAccEntity, Long> {
    Optional<UserAccEntity> findByUsername(String username);
}
