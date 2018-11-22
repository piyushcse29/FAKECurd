package com.piyushmittal.DummyUser.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class Users {

    ConcurrentHashMap<String, Users> usersMap = new ConcurrentHashMap<String, Users>();


    List<Users> usersList;

    Users(){
       usersList = new ArrayList<Users>();
    }



    String id;
    @Size(min = 3)
    String firstName;
    @Size(min = 3)
    String lastName;
    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty( value = "usersList", access = JsonProperty.Access.WRITE_ONLY)
    public List<Users> getAllUsers() {
        return usersList;
    }

    public void addUser(Users user){
        usersMap.put(user.getId(), user);
        usersList = new ArrayList<Users>(usersMap.values());
    }

    public void deleteUser(String userId){
        usersMap.remove(userId);
        usersList = new ArrayList<Users>(usersMap.values());
    }
}
