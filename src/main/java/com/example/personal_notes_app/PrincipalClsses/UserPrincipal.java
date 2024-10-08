package com.example.personal_notes_app.PrincipalClsses;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.personal_notes_app.Model.Users;

public class UserPrincipal implements UserDetails {

    private Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        try {
            return Collections.singleton(new SimpleGrantedAuthority("USER"));
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        }
    }

    @Override
    public String getPassword() {
        try {

            return user.getPassword();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
        }
    }

    

    @Override
    public String getUsername() {
        try {
            
            return user.getUsername();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
        }}
    }

