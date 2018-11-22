package com.piyushmittal.DummyUser.services;


import com.piyushmittal.DummyUser.controllers.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("DummyUsers")
public class UserService {

    @Autowired
    Users users;


    @GetMapping("/getUsers")
    List<Users> getUsers() {
        return users.getAllUsers();

    }

    @PostMapping("/addUser")
    void addUser(Users user) {
        users.addUser(user);
    }

    @PutMapping("/editUser")
    void editUser(Users user){
        addUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")

    void deleteUser(@PathVariable String userId){
        users.deleteUser(userId);
    }

}
