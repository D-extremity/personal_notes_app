package com.example.personal_notes_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.Services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/get-all-users")
    public List<Users> getAllUsers(){
        return adminService.getAllUsers();
    }
}
