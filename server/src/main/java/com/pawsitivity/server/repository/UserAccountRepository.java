package com.pawsitivity.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawsitivity.server.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    

}
