package com.example.personal_notes_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.Services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/register")
    public Users newUser(@RequestBody Users entity) {
        return userServices.createUser(entity);

    }

    @PostMapping("/login")
    public String greet(@RequestBody Users user) {

        return userServices.loginUser(user);
    }

    @GetMapping("/current-user-name")
    public String userDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }

}
