package com.epw.academy.dto;

import java.time.Instant;

public class CourseResponse {

    private Long id;
    private String name;
    private String description;
    private Integer credits;
    private Instant createdAt;

    private Long instructorId;
    private String instructorName;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCredits() {
        return credits;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}