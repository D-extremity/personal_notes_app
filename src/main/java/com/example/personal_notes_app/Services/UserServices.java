package com.example.personal_notes_app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.personal_notes_app.Model.Articles;
import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.Repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createUser(Users user) {
        user.setId(userRepository.count()+1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(user.getRoles());
        return userRepository.save(user);
    }


    
    public Users getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        return userRepository.findByUsername(currentUserName);
        
        
    }
    

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;


    public String loginUser(Users user){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        throw new UsernameNotFoundException("No user found");
    }

    public Boolean addArticle(Articles article) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        Users user = userRepository.findByUsername(currentUserName);
        user.setArticles(List.of(article));
        userRepository.save(user);
        return true;

    }
}
