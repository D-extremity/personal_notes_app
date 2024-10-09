package com.example.personal_notes_app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_notes_app.Model.Articles;

public interface ArticleRepository extends MongoRepository<Articles, Long> {

}
