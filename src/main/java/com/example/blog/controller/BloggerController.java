package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Blogger;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.BloggerRepository;
import com.example.blog.repository.CommentRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class BloggerController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BloggerRepository bloggerRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
  PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String home(){
        return "redirect:/firstPage";
    }
    @GetMapping("/firstPage")
    public String blogs(Model model){
        model.addAttribute("blog",blogRepository.findAll());
        return "firstPage";
    }
    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        var user=principal.getName();
        model.addAttribute("user",bloggerRepository.findByEmail(user));
        return "profile";
    }

    @GetMapping("/home")
    public String registeredHome(Model model){
        model.addAttribute("blogs",blogRepository.findAll());
        return "home";
    }
    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model){
        model.addAttribute("error", error);

        return "login";
    }
    @GetMapping("/blogDetail/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogRepository.findById(id).get());
        model.addAttribute("comments",commentRepository.findCommentsByBlog_Id(id));
        return "blogDetail";
    }

    @GetMapping("/createPost")
    public String createPost(){
        return "postCreation";
    }
    @PostMapping("/createPost")
    public String writeComment(Principal principal, @RequestParam String title,@RequestParam String post, Model model){
        Blog blog1=new Blog();
        var user =bloggerRepository.findByEmail(principal.getName());
        blog1.setAuthor(user);
        blog1.setTitle(title);
        blog1.setContent(post);
        blog1.setLocalDate(LocalDate.now());
        blogRepository.save(blog1);

        return "redirect:/home";
    }
    @GetMapping("/registration")
        public String register(){
        return "registration";
    }
    @PostMapping("/registration")
        public String submitRegister(@RequestParam String name, @RequestParam String email, @RequestParam String password, RedirectAttributes attributes, BindingResult bindingResult){
        if (bloggerRepository.findByEmail(email)!=null){
            return "redirect:/registration";
        }

        Blogger blogger=new Blogger();
        blogger.setName(name);
        blogger.setEmail(email);
        blogger.setPassword(passwordEncoder.encode(password));

        bloggerRepository.save(blogger);
        attributes.addFlashAttribute("dto",blogger);

        return "redirect:/login";
    }

}
