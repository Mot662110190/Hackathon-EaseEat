package com.Easeat.data.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bmr")

public class Bmr {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bmr;
    private int count;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "User_id_Bmr")
    private User user;

    public Bmr() {
    }

    public Bmr(int id, String bmr) {
        this.id = id;
        this.bmr = bmr;
    }
    public Bmr(int id, String bmr, User user) {
        this.id = id;
        this.bmr = bmr;
        this.user = user;
    }

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

  
}
