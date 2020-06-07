package com.example.blog.repository;

import com.example.blog.model.Blogger;
import org.springframework.data.repository.CrudRepository;

public interface BloggerRepository  extends CrudRepository<Blogger,Integer> {
    Blogger findByEmail(String email);
}
