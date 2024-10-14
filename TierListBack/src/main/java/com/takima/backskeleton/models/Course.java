package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer hours;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    List<Student> students;

    public Course() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getHours() {
        return hours;
    }
}
