package com.epw.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCourseRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 characters")
    private String name;

    @Size(max = 2000, message = "description must be <= 2000 characters")
    private String description;

    @Min(value = 1, message = "credits must be >= 1")
    private int credits;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
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
}