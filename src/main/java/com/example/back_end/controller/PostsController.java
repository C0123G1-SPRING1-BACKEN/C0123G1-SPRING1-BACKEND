package com.example.back_end.controller;

import com.example.back_end.dto.PostsDTO;
import com.example.back_end.model.Employees;
import com.example.back_end.model.Posts;
import com.example.back_end.service.IEmployeesService;
import com.example.back_end.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostsController {
    @Autowired
    private IPostsService iPostsService;
    @Autowired
    private IEmployeesService iEmployeesService;

    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list employees into Database
     *
     * @param
     * @return list
     */
    @GetMapping("/allEmployees")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        List<Employees> employees = iEmployeesService.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list posts into Database, pageable
     *
     * @param pageable, titleSearch
     * @return list, object
     */
    @GetMapping("")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Page<PostsDTO>> getPosts(@PageableDefault(sort = "create_date", direction = Sort.Direction.DESC) Pageable pageable,
                                                   @RequestParam(required = false, defaultValue = "") String titleSearch) {
        Page<PostsDTO> posts = iPostsService.getAllPosts(pageable, titleSearch);
        if (posts.isEmpty() && posts == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list posts into Database, pageable
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<List<Posts>> deletePost(@PathVariable Long id) {
        iPostsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list posts into Database, pageable
     *
     * @param id
     * @return object
     */
    @GetMapping("detailPosts/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Posts> detailPosts(@PathVariable Long id) {
        Optional<Posts> posts = iPostsService.findByIdPosts(id);
        if (!posts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts.get(), HttpStatus.OK);
    }

    /**
     * Created by: HuyNH
     * Date created: 17/07/2023
     * Function: display list posts into Database, pageable
     *
     * @param postsDTO
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createPosts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<?> createPosts(@Valid @RequestBody PostsDTO postsDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iPostsService.createPosts(postsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
