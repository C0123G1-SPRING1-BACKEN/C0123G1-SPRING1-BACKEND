package com.example.back_end.service.posts.impl;

import com.example.back_end.model.Posts;
import com.example.back_end.repository.IPostsRepository;
import com.example.back_end.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService implements IPostsService {
    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list posts into Database, delete post
     *   @param id
     *      @return list, object
     *
     */
    @Autowired
    private IPostsRepository iPostsRepository;
    @Override
    public List<Posts> getAllPosts() {
        return iPostsRepository.getAll();
    }

    @Override
    public void delete(Long id) {
        iPostsRepository.delete(id);
    }

    @Override
    public Posts findByIdPosts(Long id) {
        return iPostsRepository.findById(id).get();
    }
}
