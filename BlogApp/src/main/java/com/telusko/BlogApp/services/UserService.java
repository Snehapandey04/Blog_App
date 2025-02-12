package com.telusko.BlogApp.services;

import com.telusko.BlogApp.Entity.User;
import com.telusko.BlogApp.payloads.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserById(Integer userId);
   List<UserDto> getAllUsers();
   void deleteUser(Integer userId);


}
