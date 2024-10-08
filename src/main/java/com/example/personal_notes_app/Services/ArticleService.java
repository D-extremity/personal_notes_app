package com.example.personal_notes_app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.personal_notes_app.Model.Articles;
import com.example.personal_notes_app.Model.Users;
import com.example.personal_notes_app.Repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public Articles newArticle(Articles article){
        userServices.addArticle(article);
        return articleRepository.save(article);

    }

    public List<Articles> getUserArticles(){
        
        Users user=userServices.getCurrentUser();
        return user.getArticles();
    }
    
}
