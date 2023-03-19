package com.digitalmedia.users.controller;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import com.digitalmedia.users.repository.KeycloakUserRepository;
import com.digitalmedia.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  KeycloakUserRepository service;

    @GetMapping("/name/{nombreUser}")
    public User findByName(@PathVariable("nombreUser") String name){
        return service.findByUsername(name);
    }



}

