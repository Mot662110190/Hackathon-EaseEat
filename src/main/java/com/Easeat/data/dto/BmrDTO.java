package com.Easeat.data.dto;

import java.time.LocalDateTime;

public class BmrDTO {
 private int id;
    private String bmr;
    private int count;
    private LocalDateTime date;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBmr() {
        return bmr;
    }
    public void setBmr(String bmr) {
        this.bmr = bmr;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
