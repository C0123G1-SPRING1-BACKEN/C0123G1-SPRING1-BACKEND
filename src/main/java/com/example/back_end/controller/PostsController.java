package com.example.back_end.controller;

import com.example.back_end.model.Employees;
import com.example.back_end.model.Posts;
import com.example.back_end.service.employees.IEmployeesService;
import com.example.back_end.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Posts>> getPosts() {
        List<Posts> posts = iPostsService.getAllPosts();
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
    public ResponseEntity<List<Posts>> deleteOrder(@PathVariable Long id) {
        iPostsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    };
    @GetMapping("findPostsById/{id}")
    public ResponseEntity<Posts> findPostsById(@PathVariable Long id) {
        iPostsService.findByIdPosts(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
