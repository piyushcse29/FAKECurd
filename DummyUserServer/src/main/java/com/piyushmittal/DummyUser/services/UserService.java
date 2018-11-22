package com.piyushmittal.DummyUser.services;


import com.piyushmittal.DummyUser.UserNotFoundException;
import com.piyushmittal.DummyUser.controllers.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("DummyUsers")
public class UserService {

    @Autowired
    Users users;


    @GetMapping("/getUsers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Users> getUsers() {
        if(users.getAllUsers().size() == 0)
            throw new UserNotFoundException("No user found");
        return users.getAllUsers();

    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    void addUser(Users user) {
        users.addUser(user);
    }

    @PutMapping("/editUser")
    void editUser(@RequestBody Users user){
        addUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteUser(@PathVariable String userId){
        users.deleteUser(userId);
    }

}
