package com.example.back_end.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "DATETIME DEFAULT now()")
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    private Employees employees;

    public Posts() {
    }

    public Posts(Long id, String title, String image, String content, LocalDateTime createDate, Employees employees) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createDate = createDate;
        this.employees = employees;
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

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}

//    @ManyToMany
//    @JoinTable(
//            name = "course_like",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    Set<Course> likedCourses;

//@Embeddable
//class CourseRatingKey implements Serializable {
//
//    @Column(name = "student_id")
//    Long studentId;
//
//    @Column(name = "course_id")
//    Long courseId;
//
//@Entity
//class CourseRating {
//
//    @EmbeddedId
//    CourseRatingKey id;
//
//    @ManyToOne
//    @MapsId("studentId")
//    @JoinColumn(name = "student_id")
//    Student student;
//
//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    Course course;
//
//    int rating;



//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    //...
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address; // biến address này sẽ trùng  với giá trị  mappedBy trong Class User
//
//// ... getters and setters

//@Entity
//@Table(name = "address")
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    //...
//
//    @OneToOne(mappedBy = "address")
//    private User user;
//
////... getters and setters


//@Entity
//@Table(name = "student")
//public class Student {
//
//    @Id
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToMany         (cascade = CascadeType.ALL) co the co or khong
//    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
//    @JsonManagedReference
//    private Set<Course> likedCourses;
//}
//
//@Entity
//@Table(name = "course")
//public class Course {
//
//    @Id
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToMany(mappedBy = "likedCourses")
//    @JsonBackReference
//    private Set<Student> likes;
//}
//@Embeddable
//class CourseRatingKey implements Serializable {
//
//    @Column(name = "student_id")
//    Long studentId;
//
//    @Column(name = "course_id")
//    Long courseId;
//
//    // standard constructors, getters, and setters
//    // hashcode and equals implementation
//}
//@Entity
//@Table(name = "student_course")
//public class StudentCourse {
//
//    @EmbeddedId
//    private CourseRatingKey id;
//
//    @ManyToOne
//    @MapsId("student_id")
//    @JoinColumn(name = "student_id")
//    private Student student;
//
//    @ManyToOne
//    @MapsId("course_id")
//    @JoinColumn(name = "course_id")
//    private Course course;
//}