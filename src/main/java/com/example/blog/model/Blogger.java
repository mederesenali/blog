package com.example.blog.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
//@Builder
public class Blogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;
    @Builder.Default
    private boolean enabled=true;
    @Builder.Default
    private String role="USER";
    public Blogger(){

    }
}
