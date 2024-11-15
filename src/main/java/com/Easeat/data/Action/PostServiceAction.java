package com.Easeat.data.Action;

import java.time.LocalDateTime;
import java.util.List;

import com.Easeat.data.Entity.Post;
import com.Easeat.data.services.PostService;
import com.Easeat.data.services.UserService;

public class PostServiceAction implements PostService{

    @Override
    public Post save(Post post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Post> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Post findByTitle(String Title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTitle'");
    }

    @Override
    public Post findByCreatedAt(LocalDateTime createdAt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCreatedAt'");
    }

}
