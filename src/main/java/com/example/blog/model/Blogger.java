package com.example.blog.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Blogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Column(length = 128)
    private String password;
    private String name;
    @Builder.Default
    private boolean enabled=true;
    @Builder.Default
    private String role="USER";

}
