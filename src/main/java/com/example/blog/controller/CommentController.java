package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Comment;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.BloggerRepository;
import com.example.blog.repository.CommentRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BloggerRepository bloggerRepository;
    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/createComment")
    public String createComment(Principal principal, @RequestParam String comment, @RequestParam int blogId,Model model){
        Blog blog=blogRepository.findById(blogId).get();
        Comment comment1=new Comment();
        var user =bloggerRepository.findByEmail(principal.getName());
        comment1.setBlogger(user);
        comment1.setComment(comment);
        comment1.setLocalDate(LocalDate.now());
        comment1.setBlog(blog);
        commentRepository.save(comment1);
        model.addAttribute("blog", blogRepository.findById(blogId).get());
        model.addAttribute("comments",commentRepository.findCommentsByBlog_Id(blogId));
        return "blogDetail";


    }


}
