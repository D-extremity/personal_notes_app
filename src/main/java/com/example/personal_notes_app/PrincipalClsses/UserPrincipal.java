package com.example.personal_notes_app.PrincipalClsses;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

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
            Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toSet());
            return authorities;
            // return Collections.singleton(new SimpleGrantedAuthority("USER"));
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

