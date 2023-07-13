package com.example.back_end.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String image;
    private String content;
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private Employee employee;

    public Posts() {
    }

    public Posts(Long id, String title, String image, String content, LocalDateTime createDate, Employee employee) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createDate = createDate;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Employee getEmployees() {
        return employee;
    }

    public void setEmployees(Employee employee) {
        this.employee = employee;
    }
}
