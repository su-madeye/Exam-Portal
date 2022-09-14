package com.example.examserver.service;

import com.example.examserver.models.User;
import com.example.examserver.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);
    public void deleteUser(String username);
}
