package com.Easeat.data.dto;

import java.util.List;


public class UserDTO {
    private int id;
    
    private String name;
    private String username;
    private String password;
    private List<StrainDTO> strain;
    private List<BmrDTO> bmr;
    private List<PostDTO> post;
    
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<StrainDTO> getStrain() {
        return strain;
    }
    public void setStrain(List<StrainDTO> strain) {
        this.strain = strain;
    }
    public List<BmrDTO> getBmr() {
        return bmr;
    }
    public void setBmr(List<BmrDTO> bmr) {
        this.bmr = bmr;
    }
    public List<PostDTO> getPost() {
        return post;
    }
    public void setPost(List<PostDTO> post) {
        this.post = post;
    }


}
