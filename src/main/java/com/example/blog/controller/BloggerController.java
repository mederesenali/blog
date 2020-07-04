package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Blogger;
import com.example.blog.model.BloggerRegisterForm;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.BloggerRepository;
import com.example.blog.repository.CommentRepository;
import com.example.blog.service.BloggerService;
import com.example.blog.service.CustomerAlreadyRegisteredException;
import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class BloggerController {

   private final BlogRepository blogRepository;
   private final BloggerRepository bloggerRepository;

   private final BloggerService bloggerService;
private  final     CommentRepository commentRepository;

  private  final   PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String home() {
        return "redirect:/firstPage";
    }

    @GetMapping("/firstPage")
    public String blogs(Model model) {
        model.addAttribute("blog", blogRepository.findAll());
        return "firstPage";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String user = principal.getName();
        model.addAttribute("user", bloggerRepository.findByEmail(user).get());
        return "profile";
    }

    @GetMapping("/home")
    public String registeredHome(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);

        return "login";
    }

    @GetMapping("/blogDetail/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogRepository.findById(id).get());
        model.addAttribute("comments", commentRepository.findCommentsByBlog_Id(id));
        return "blogDetail";
    }

    @GetMapping("/createPost")
    public String createPost() {
        return "postCreation";
    }

    @PostMapping("/createPost")
    public String writeComment(Principal principal, @RequestParam String title, @RequestParam String post, Model model) {
        Blog blog1 = new Blog();
        Blogger user = bloggerRepository.findByEmail(principal.getName()).get();
        blog1.setAuthor(user);
        blog1.setTitle(title);
        blog1.setContent(post);
        blog1.setLocalDate(LocalDate.now());
        blogRepository.save(blog1);

        return "redirect:/home";
    }

    @GetMapping("/registration")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new BloggerRegisterForm());
        }

        return "registration";
    }

    @PostMapping("/registration")
    public String registerPage(@Valid BloggerRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) throws CustomerAlreadyRegisteredException {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/registration";
        }

        bloggerService.register(customerRequestDto);
        return "redirect:/login";
    }

}
