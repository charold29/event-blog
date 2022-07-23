package com.devdoteros.eventblog.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String image;

    private int likes;

    private int dislikes;

    private String duration;

    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
}
