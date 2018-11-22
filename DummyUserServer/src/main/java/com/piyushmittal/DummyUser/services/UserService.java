package com.piyushmittal.DummyUser.services;


import com.piyushmittal.DummyUser.UserNotFoundException;
import com.piyushmittal.DummyUser.controllers.Users;
import com.piyushmittal.DummyUser.util.DefaultMesage;
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

    @Autowired
    DefaultMesage defaultMesage;


    @GetMapping("/getUsers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Users> getUsers() {
        if (users.getAllUsers().size() == 0)
            throw new UserNotFoundException("No user found");
        return users.getAllUsers();
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Object>  addUser(Users user) {
       String response = users.addUser(user);
        defaultMesage.setResponse(response);
        return new ResponseEntity(defaultMesage, HttpStatus.CREATED);
    }

    @PutMapping("/editUser")
    ResponseEntity<Object> editUser(Users user) {
        String response = users.editUser(user);
        defaultMesage.setResponse(response);
        return new ResponseEntity(defaultMesage, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<Object> deleteUser(@PathVariable String userId) {
        String response = users.deleteUser(userId);
        defaultMesage.setResponse(response);
        return new ResponseEntity(defaultMesage, HttpStatus.CREATED);
    }

}
