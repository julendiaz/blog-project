package com.julentech.blogproject.controller;

import com.julentech.blogproject.User;
import com.julentech.blogproject.UserDetails;
import com.julentech.blogproject.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, User> users;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        User returnValue = new User();
        returnValue.setId(userId);
        returnValue.setFirstname("Paco");
        returnValue.setLastName("olga");
        return new ResponseEntity<User>(returnValue, HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(consumes = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },  produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public String createUser(@RequestBody UserDetails userDetails) {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }





}
