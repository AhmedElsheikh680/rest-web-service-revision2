package com.rest.api.controller;

import com.rest.api.model.User;
import com.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
       User user =  userService.findUser(id);
    // "users", SERVER_PATH, "/users"
    //retrieveAllUsers
    //HATEOAS
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).users());
        resource.add(linkTo.withRel("users"));

       return resource;

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
