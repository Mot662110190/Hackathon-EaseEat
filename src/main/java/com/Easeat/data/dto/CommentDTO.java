package com.Easeat.data.dto;

import java.time.LocalDateTime;

public class CommentDTO {
 private int id;
    private String body;
    private LocalDateTime date;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
}
