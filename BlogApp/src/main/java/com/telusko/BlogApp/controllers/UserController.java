package com.telusko.BlogApp.controllers;

import com.telusko.BlogApp.payloads.ApiResponse;
import com.telusko.BlogApp.payloads.UserDto;
import com.telusko.BlogApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

     @Autowired
    private UserService userService;



@PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
   UserDto createuserDto =  this.userService.createUser(userDto);
   return new ResponseEntity<>(createuserDto, HttpStatus.CREATED);

    }
@PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto , @PathVariable("userId") Integer uid){
  UserDto updatedUser =  this.userService.updateUser(userDto , uid);
  return ResponseEntity.ok(updatedUser);


    }
@DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
    this.userService.deleteUser(uid);
    return new  ResponseEntity (new ApiResponse("User deleted Successfully" , true), HttpStatus.OK);

    }

@GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){

      return ResponseEntity.ok(this.userService.getAllUsers());

    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getSingleUser(@PathVariable Integer userId){

        return ResponseEntity.ok(this.userService.getUserById(userId));

    }

    }



