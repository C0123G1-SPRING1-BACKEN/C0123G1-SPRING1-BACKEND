package com.example.back_end.service;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.dto.PostsDTO;
import com.example.back_end.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPostsService {
    Page<PostsDTO> getAllPosts(Pageable pageable,String titleSearch);

    void delete(Long id);
    Optional<Posts> findByIdPosts(Long id);
    void createPosts(PostsDTO postsDTO);
}
