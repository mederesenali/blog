package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    private LocalDate localDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
     private Blog blog;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blogger_id")
    private Blogger blogger;


}
