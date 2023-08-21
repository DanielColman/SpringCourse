package com.example.users.controllers;

import com.example.users.models.User;
import com.example.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//dEFINICION DE MI RECURSO
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    //Metodo HTTP + Recurso --> Handler methods.
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value="/{username}")
    public ResponseEntity<User> getUsersByUsername(@PathVariable("username") String username){
        return new ResponseEntity<User> (userService.getUsersByUserName(username), HttpStatus.OK);
    }
}
