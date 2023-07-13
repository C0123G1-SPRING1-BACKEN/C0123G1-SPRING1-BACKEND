package com.example.back_end.service.posts;

import com.example.back_end.model.Posts;

import java.util.List;

public interface IPostsService {
    List<Posts> getAllPosts();
    void delete(Long id);
    Posts findByIdPosts(Long id);
}
