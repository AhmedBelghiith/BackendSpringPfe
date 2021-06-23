package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.AuthRequest;
import com.bandsmile.crud.model.User;
import com.bandsmile.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/AddUser")
    public User addUser (@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("/AddUsers")
    public List<User> addUsers (@RequestBody List<User> users){
        return userService.saveUsers(users);
    }

    @GetMapping("/Users")
    public List<User> findAllUsers(){
        return userService.getUser();
    }

    @GetMapping("/UserById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/UserByUsername/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/UserByName/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PutMapping("/UpdateUser")
    public User updateUser (@RequestBody User user){
        return userService.upadateUser(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String deleteUser (@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
