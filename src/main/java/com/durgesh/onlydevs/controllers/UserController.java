package com.durgesh.onlydevs.controllers;

import com.durgesh.onlydevs.entities.LoginUser;
import com.durgesh.onlydevs.entities.User;
import com.durgesh.onlydevs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
       User result= userRepository.save(user);
       return "user added";

    }
    @PostMapping("/login")
    public String login(@RequestBody LoginUser loginUser) {
       User result= userRepository.getUserByEmail(loginUser.getEmail());
       if(result!=null) {
           if(result.getPassword().equals(loginUser.getPassword())) {
               return "Login Successsfull";
           }
           else{
               return "Wrong email or password";
           }
       }
       else {
           return "User Not Found Please Sign Up";
       }


    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User>users=(List<User>) userRepository.findAll();
        return users;
    }
    @DeleteMapping("/users")
    public String deleteAllUsers(){
        userRepository.deleteAll();
        return "users deleted";
    }
}
