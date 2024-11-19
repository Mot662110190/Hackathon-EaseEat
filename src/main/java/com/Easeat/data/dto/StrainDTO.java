package com.Easeat.data.dto;

import java.time.LocalDateTime;

public class StrainDTO {
 private int id;
    private int count;
    private String levels;
    private LocalDateTime date;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getLevels() {
        return levels;
    }
    public void setLevels(String levels) {
        this.levels = levels;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
