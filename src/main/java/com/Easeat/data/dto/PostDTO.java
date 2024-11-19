package com.Easeat.data.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
 private int id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private String Category;
    private List<CommentDTO> Comment;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public List<CommentDTO> getComment() {
        return Comment;
    }
    public void setComment(List<CommentDTO> comment) {
        Comment = comment;
    }
}
