package com.example.personal_notes_app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.Repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
      return  userRepository.findAll();
    }
    
}
