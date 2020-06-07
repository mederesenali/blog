package com.example.blog.repository;

import com.example.blog.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
    List<Comment> findCommentsByBlog_Id(int id);
}
