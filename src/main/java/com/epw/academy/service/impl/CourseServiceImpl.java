package com.epw.academy.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.academy.dto.CourseResponse;
import com.epw.academy.dto.CreateCourseRequest;
import com.epw.academy.entity.Course;
import com.epw.academy.entity.Instructor;
import com.epw.academy.exception.ResourceNotFoundException;
import com.epw.academy.repository.CourseRepository;
import com.epw.academy.repository.InstructorRepository;
import com.epw.academy.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final InstructorRepository instructorRepository;

    public CourseServiceImpl(CourseRepository repository, InstructorRepository instructorRepository) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {

        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());

        // Relación ManyToOne (Course -> Instructor)
        if (request.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(request.getInstructorId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Instructor " + request.getInstructorId() + " not found"));

            course.setInstructor(instructor);
        }

        Course saved = repository.save(course);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setCredits(course.getCredits());
        response.setCreatedAt(course.getCreatedAt());

        if (course.getInstructor() != null) {
            response.setInstructorId(course.getInstructor().getId());
            response.setInstructorName(course.getInstructor().getName());
        }

        return response;
    }
}