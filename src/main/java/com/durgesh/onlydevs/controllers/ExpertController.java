package com.durgesh.onlydevs.controllers;

import com.durgesh.onlydevs.entities.Expert;
import com.durgesh.onlydevs.entities.User;
import com.durgesh.onlydevs.repositories.ExpertRepository;
import com.durgesh.onlydevs.repositories.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpertController {

    @Autowired
    ExpertRepository expertRepository;

    @GetMapping("/experts")
    public List<Expert> getAllExperts(){
        List<Expert>experts=(List<Expert>) expertRepository.findAll();
        return experts;
    }
}
