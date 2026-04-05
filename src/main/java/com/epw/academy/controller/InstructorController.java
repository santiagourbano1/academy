package com.epw.academy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.epw.academy.dto.CreateInstructorRequest;
import com.epw.academy.dto.InstructorResponse;
import com.epw.academy.service.InstructorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstructorResponse create(@Valid @RequestBody CreateInstructorRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<InstructorResponse> list() {
        return service.list();
    }
}