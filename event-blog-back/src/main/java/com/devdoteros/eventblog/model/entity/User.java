package com.devdoteros.eventblog.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotBlank
    private int age;

    @OneToMany
    private List<Category> categories;

    public User() {
        categories = new ArrayList<>();
    }

}
