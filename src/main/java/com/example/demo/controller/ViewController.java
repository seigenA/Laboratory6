package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view-all-tasks")
    public String viewAllTasks() {
        return "view-all-tasks";
    }

    @GetMapping("/view-all-categories")
    public String viewAllCategories() {
        return "view-all-categories";
    }

    @GetMapping("/view-profile")
    public String viewProfile() {
        return "view-profile";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}

