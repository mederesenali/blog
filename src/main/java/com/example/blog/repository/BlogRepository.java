package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Integer> {
    List<Blog> findAllByTitle(String title);
}
