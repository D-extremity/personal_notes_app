package com.example.personal_notes_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personal_notes_app.Model.Articles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.personal_notes_app.Services.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleServices;

    @PostMapping("/new-article")
    public Articles newArticle(@RequestBody Articles article) {

        return articleServices.newArticle(article);

    }


    @GetMapping("/get-all-articles")
    public List<Articles> getMethodName() {
        return articleServices.getUserArticles();
    }
    

}
