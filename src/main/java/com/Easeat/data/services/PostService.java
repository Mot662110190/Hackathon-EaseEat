package com.Easeat.data.services;

import java.time.LocalDateTime;
import java.util.List;

import com.Easeat.data.Entity.Post;

public interface PostService {
         Post save(Post post);
         List<Post> findAll();
         Post findByTitle(String Title);
         Post findById(Integer id); 
         void deleteById(Integer id);
         void deleteAll();
}
