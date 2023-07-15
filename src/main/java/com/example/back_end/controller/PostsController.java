package com.example.back_end.controller;

import com.example.back_end.model.Employees;
import com.example.back_end.model.Posts;
import com.example.back_end.service.employees.IEmployeesService;
import com.example.back_end.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostsController {
    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list posts into Database, delete post
     * @param id
     * @return list,object
     *
     */
    @Autowired
    private IPostsService iPostsService;

    @Autowired
    private IEmployeesService iEmployeesService;
    @GetMapping("")
    public ResponseEntity<Page<Posts>> getPosts(@PageableDefault(size = 3) Pageable pageable) {
        Page<Posts> posts = iPostsService.getAllPosts(pageable);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("employees")
    public ResponseEntity<List<Employees>> getEmployees() {
        List<Employees> employees = iEmployeesService.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Posts>> deletePost(@PathVariable Long id) {
        iPostsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    };
    @GetMapping("detailPosts/{id}")
    public ResponseEntity<Posts> detailPosts(@PathVariable Long id) {
         Optional<Posts> posts = iPostsService.findByIdPosts(id);
         if (!posts.isPresent()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(posts.get(),HttpStatus.OK);
    }
    @GetMapping("findPostsByName/{title}")
    public ResponseEntity<List<Posts>> findPostsByTitle(@PathVariable String title) {
        List<Posts> postsList = iPostsService.findByNamePosts(title);
        if (postsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postsList,HttpStatus.OK);
    }
}
