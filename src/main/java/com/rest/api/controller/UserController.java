package com.rest.api.controller;

import com.rest.api.exception.UserNotFoundException;
import com.rest.api.model.User;
import com.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
       return userService.findUser(id);
//        User user =  userService.findUser(id);
//        if(user == null)
//            throw new UserNotFoundException("id-> "+id);
//
//        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
       User savedUser =   userService.addUser(user);
       URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(savedUser.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
         userService.deleteuser(id);

    }


}
