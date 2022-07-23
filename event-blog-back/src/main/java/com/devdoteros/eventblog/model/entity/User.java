package com.devdoteros.eventblog.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
