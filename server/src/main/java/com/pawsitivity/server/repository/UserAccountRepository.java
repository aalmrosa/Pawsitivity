package com.pawsitivity.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawsitivity.server.model.UserAccEntity;

public interface UserAccountRepository extends JpaRepository<UserAccEntity, Long> {

    

}
