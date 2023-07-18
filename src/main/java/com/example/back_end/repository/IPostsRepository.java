package com.example.back_end.repository;

import com.example.back_end.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IPostsRepository extends JpaRepository<Posts, Long> {
    @Query(value = "select * from posts p join employees e on p.employees_id = e.id where title like concat('%', :titleSearch, '%')", nativeQuery = true)
    Page<Posts> findNameAllPosts(Pageable pageable, @Param("titleSearch") String titleSearch);

    @Modifying
    @Transactional
    @Query(value = "delete from posts where id = ?", nativeQuery = true)
    void delete(Long id);

    @Query(value = "select * from posts p join employees e on p.employees_id = e.id where p.id = ?", nativeQuery = true)
    Optional<Posts> findById(Long id);

//    @Query(value = "select * from posts p join employees e on p.employees_id = e.id where p.title like %:name%", nativeQuery = true)
//    List<Posts> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into posts (title, content, create_date, image, employees_id) values (:title, :content, :createDate, :image, :employees)", nativeQuery = true)
    void createPosts(@Param("title") String title,
                     @Param("content") String content,
                     @Param("createDate") LocalDateTime createDate,
                     @Param("image") String image,
                     @Param("employees") Long employees);
}
