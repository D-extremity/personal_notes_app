package com.example.personal_notes_app.Model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Document(collection = "Users")
public class Users {
    @Indexed(unique = true)
    private String username;
    private String password;
    @Id
    private long id;
    @DBRef
    private List<Articles> articles;
    private Set<String> roles;

}
