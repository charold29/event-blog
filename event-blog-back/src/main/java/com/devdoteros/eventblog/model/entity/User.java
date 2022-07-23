package com.devdoteros.eventblog.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Range(max = 100L)
    private int age;

    @OneToMany
    private List<Category> categories;

    public User() {
        categories = new ArrayList<>();
    }

}
