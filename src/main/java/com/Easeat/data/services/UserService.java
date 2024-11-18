package com.Easeat.data.services;

import java.util.List;

import com.Easeat.data.Entity.User;


public interface UserService {
     User save(User user);
     List<User> findAll();
     User findById(Integer id);
     void deleteById(Integer id);
    
}