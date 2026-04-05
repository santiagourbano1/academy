package com.epw.academy.dto;

import java.time.Instant;

public class CourseResponse {

    private Long id;
    private String name;
    private String description;
    private int credits;
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
    }

    public Instant getCreatedAt() {
        return createdAt;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}