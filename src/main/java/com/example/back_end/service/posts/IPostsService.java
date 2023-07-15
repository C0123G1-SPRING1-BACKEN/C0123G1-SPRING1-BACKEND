package com.example.back_end.service.posts;

import com.example.back_end.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPostsService {
    Page<Posts> getAllPosts(Pageable pageable);

    void delete(Long id);
    Optional<Posts> findByIdPosts(Long id);
    List<Posts> findByNamePosts(String title);
}
