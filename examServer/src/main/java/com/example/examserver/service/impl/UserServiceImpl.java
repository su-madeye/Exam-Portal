package com.example.examserver.service.impl;

import com.example.examserver.models.User;
import com.example.examserver.models.UserRole;
import com.example.examserver.repo.RoleRepo;
import com.example.examserver.repo.UserRepo;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void deleteUser(String username) {
        userRepo.delete(userRepo.findByUsername(username));
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        System.out.println("creating new user " + user.getUsername());
        User localUser = userRepo.findByUsername(user.getUsername());
        if(localUser == null) {
            userRoles.forEach(ur -> {
                roleRepo.save(ur.getRole());
            });
            user.getUserRoles().addAll(userRoles);
            return userRepo.save(user);
        }
        else {
            throw new Exception("User with username already exists!");
        }
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("user with username " + username + " not found");
        }
        return user;
    }
}
