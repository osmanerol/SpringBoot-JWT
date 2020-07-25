package com.springboot.jwttoken.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.springboot.jwttoken.Entities.Developer;
import com.springboot.jwttoken.Repository.DeveloperRepository;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DeveloperController(DeveloperRepository developerRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.developerRepository = developerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Developer developer) {
        developer.setPassword(bCryptPasswordEncoder.encode(developer.getPassword()));
        developerRepository.save(developer);
    }
}