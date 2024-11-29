package com.example.demo.controller;

import entity.User;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public User getUserProfile(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/edit")
    public User editUserProfile(@RequestBody User user, @RequestParam Long userId) {
        return userService.updateUser(user, userId);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email) {
        return userService.resetPassword(email);
    }
}