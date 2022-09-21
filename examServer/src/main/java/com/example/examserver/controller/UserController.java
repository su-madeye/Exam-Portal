package com.example.examserver.controller;

import com.example.examserver.models.Role;
import com.example.examserver.models.User;
import com.example.examserver.models.UserRole;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoles = new HashSet<>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setRoleName("USER");
        role.setRoleId(123L);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);
        return userService.createUser(user, userRoles);
    }

    @GetMapping("/find/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {
        User user = userService.getUser(username);
        if(user == null)
        {
            throw new Exception(username + " not found");
        }
        return user;
    }

    @DeleteMapping("/delete/{username}")
    public void deleteUser(@PathVariable("username") String username) throws Exception {
        userService.deleteUser(username);
    }
}
