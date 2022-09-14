package com.example.examserver.service.impl;

import com.example.examserver.models.User;
import com.example.examserver.models.UserRole;
import com.example.examserver.repo.RoleRepo;
import com.example.examserver.repo.UserRepo;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
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
            throw new RuntimeException("User with username already exists!");
        }
    }
}
