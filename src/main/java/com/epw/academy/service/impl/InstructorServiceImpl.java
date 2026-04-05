package com.epw.academy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.academy.dto.CreateInstructorRequest;
import com.epw.academy.dto.InstructorResponse;
import com.epw.academy.entity.Instructor;
import com.epw.academy.repository.InstructorRepository;
import com.epw.academy.service.InstructorService;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository repository;

    public InstructorServiceImpl(InstructorRepository repository) {
        this.repository = repository;
    }

    @Override
    public InstructorResponse create(CreateInstructorRequest request) {

        Instructor instructor = new Instructor();
        instructor.setName(request.getName());
        instructor.setEmail(request.getEmail());

        Instructor saved = repository.save(instructor);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstructorResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private InstructorResponse toResponse(Instructor instructor) {
        InstructorResponse response = new InstructorResponse();
        response.setId(instructor.getId());
        response.setName(instructor.getName());
        response.setEmail(instructor.getEmail());
        return response;
    }
}