package com.example.personal_notes_app.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Document(collection="Articles")
public class Articles {
    private String articleTitle;
    private String article;
    @Id
    private long articleID;

}
