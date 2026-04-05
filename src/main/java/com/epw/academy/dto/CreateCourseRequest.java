package com.epw.academy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCourseRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;

    @Size(max = 2000, message = "description must be <= 2000 chars")
    private String description;

    @NotNull(message = "credits is required")
    private Integer credits;

    private Long instructorId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCredits() {
        return credits;
    }

    public Long getInstructorId() {
        return instructorId;
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

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

public class CreateInstructorRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    @Size(max = 150, message = "email must be <= 150 chars")
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
}