package com.Easeat.data.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String username;
    private String password;
    private int member = 0;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Strain> strain;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bmr> bmr;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> post;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String chat;

   
    public User() {
    }
    public User(int id, String name,List<Strain> Strain,List<Bmr> Bmr,List<Post> Post) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getChat() {
        return chat;
    }
    public void setChat(String chat) {
        this.chat = chat;
    }
    public List<Strain> getStrain() {
        return strain;
    }
    public void setStrain(List<Strain> strain) {
        this.strain = strain;
    }
    public List<Bmr> getBmr() {
        return bmr;
    }
    public void setBmr(List<Bmr> bmr) {
        this.bmr = bmr;
    }
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }
    public int getMember() {
        return member;
    }
    public void setMember(int member) {
        this.member = member;
    }
    

  

}
