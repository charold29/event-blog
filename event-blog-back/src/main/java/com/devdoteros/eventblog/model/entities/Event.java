package com.devdoteros.eventblog.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    private Integer likes;

    private Integer dislikes;

    private String duration;

    private String status;


}
