package com.wipro.hca.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.hca.vendingmachine.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    @Modifying
    @Query("update User user set user.accountBalance = ?1 where user.email = ?2")
    Integer updateAccountBalance(Double accountBalance, String email);
}
