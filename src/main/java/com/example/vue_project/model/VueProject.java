package com.example.vue_project.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="vue_project")
public class VueProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="published")
    private boolean published;
}
