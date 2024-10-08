package com.example.personal_notes_app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.PrincipalClsses.UserPrincipal;
import com.example.personal_notes_app.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=userRepo.findByUsername(username);
        if(user!=null){
            return new UserPrincipal(user);
        }
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
    
}
