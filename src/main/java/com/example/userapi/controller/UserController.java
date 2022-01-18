package com.example.userapi.controller;

import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user=userRepository.findById(id).orElseThrow(() -> new ResolutionException("User does not exist with id :" +id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userDetails){
        User updateUser=userRepository.findById(id).orElseThrow(() -> new ResolutionException(("User does not exist with id :" +id)));
        updateUser.setUserName(userDetails.getUserName());
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setMobileNumber(userDetails.getMobileNumber());
        updateUser.setEmailId(userDetails.getEmailId());
        updateUser.setAddress1(userDetails.getAddress1());
        updateUser.setAddress2(userDetails.getAddress2());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        User user=userRepository.findById(id).orElseThrow(() -> new ResolutionException(("User does not exist with id :" +id)));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}