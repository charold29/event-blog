package com.devdoteros.eventblog.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String image;

    private int like;

    private int dislike;

    private String duration;

    private String status;

    @Column(name = "category_id")
    private Long categoryId;

}
