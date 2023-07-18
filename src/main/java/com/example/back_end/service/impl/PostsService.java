package com.example.back_end.service.impl;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.dto.PostsDTO;
import com.example.back_end.model.Employees;
import com.example.back_end.model.Posts;
import com.example.back_end.repository.IPostsRepository;
import com.example.back_end.service.IPostsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Page<PostsDTO> getAllPosts(Pageable pageable, String titleSearch) {
        List<PostsDTO> postsDTOList = new ArrayList<>();
        Page<Posts> postsPage = iPostsRepository.findNameAllPosts(pageable, titleSearch);
        PostsDTO postsDTO;
        for (Posts posts : postsPage) {
            postsDTO = new PostsDTO();
            BeanUtils.copyProperties(posts, postsDTO);
            postsDTOList.add(postsDTO);
        }
        return new PageImpl<>(postsDTOList, pageable, postsPage.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        iPostsRepository.delete(id);
    }

    @Override
    public Optional<Posts> findByIdPosts(Long id) {
        return iPostsRepository.findById(id);
    }


    @Override
    public void createPosts(PostsDTO postsDTO) {
        Posts posts = new Posts();
        BeanUtils.copyProperties(postsDTO, posts);
        iPostsRepository.createPosts(
                posts.getTitle(),
                posts.getContent(),
                posts.getCreateDate(),
                posts.getImage(),
                posts.getEmployees().getId()
        );
    }
}
