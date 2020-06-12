package com.example.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "notes")
public class Note {

    @Id
    private String id;
    private String title;
    private String content;
    private Date createdAt;


}
