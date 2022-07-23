package com.devdoteros.eventblog.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    private String name;

    private String email;

    private String password;

    private String username;

    private int age;

    @OneToMany
    private List<Category> categories;

    public User() {
        categories = new ArrayList<>();
    }

}
