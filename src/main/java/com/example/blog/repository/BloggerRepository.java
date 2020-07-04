package com.example.blog.repository;

import com.example.blog.model.Blogger;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BloggerRepository  extends CrudRepository<Blogger,Integer> {
   // Blogger findByEmail(String email);
    boolean existsByEmail(String email);

    Optional<Blogger> findByEmail(String email);
}
