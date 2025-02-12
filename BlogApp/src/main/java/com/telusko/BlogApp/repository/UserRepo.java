package com.telusko.BlogApp.repository;

import com.telusko.BlogApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Integer> {

   // User findUserByEmail(String email);

}
