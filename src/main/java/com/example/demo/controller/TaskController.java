package com.example.demo.controller;

import entity.Task;
import entity.User;
import service.TaskService;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Page<Task> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return taskService.getAllTasks(page, size);
    }

    @GetMapping("/user")
    public List<Task> getUserTasks(@RequestParam Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task, @RequestParam Long adminId) {
        User admin = userService.getUserById(adminId);
        if (admin.getRole() != User.Role.ADMIN) {
            throw new IllegalArgumentException("Only admins can add tasks");
        }
        return taskService.saveTask(task);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String keyword) {
        return taskService.searchTasks(keyword);
    }
}