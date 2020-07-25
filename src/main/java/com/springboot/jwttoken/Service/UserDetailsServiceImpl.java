package com.springboot.jwttoken.Service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.jwttoken.Entities.Developer;
import com.springboot.jwttoken.Repository.DeveloperRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private DeveloperRepository developerRepository;

    public UserDetailsServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Developer developer = developerRepository.findByUsername(username);
        if (developer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(developer.getUsername(), developer.getPassword(), emptyList());
    }
}