package com.museumonline.museumonline.controller;
import com.museumonline.museumonline.dto.LoginRequest;
import com.museumonline.museumonline.model.User;
import com.museumonline.museumonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/users/1
    public ResponseEntity<User> getUserById(@PathVariable("id") long userID){
        return new ResponseEntity<User>(userService.getUserById(userID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,
                                                   @RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        //delete user from db
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted Successfully.",HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(user);
    }

}