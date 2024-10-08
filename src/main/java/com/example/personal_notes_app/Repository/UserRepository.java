package com.example.personal_notes_app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_notes_app.Model.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {
    Users findByUsername(String username);
}
