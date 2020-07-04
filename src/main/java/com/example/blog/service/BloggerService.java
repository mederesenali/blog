package com.example.blog.service;

import com.example.blog.model.Blogger;
import com.example.blog.model.BloggerDTO;
import com.example.blog.model.BloggerRegisterForm;
import com.example.blog.repository.BloggerRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BloggerService {
    private final BloggerRepository repository;

    private final PasswordEncoder encoder;

    public BloggerDTO register(BloggerRegisterForm form) throws CustomerAlreadyRegisteredException {
        if (repository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var user = Blogger.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return BloggerDTO.from(user);
    }
}
