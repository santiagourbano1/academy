package com.epw.academy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.academy.dto.CourseResponse;
import com.epw.academy.dto.CreateCourseRequest;
import com.epw.academy.entity.Course;
import com.epw.academy.repository.CourseRepository;
import com.epw.academy.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {

        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());

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
        return response;
    }
}