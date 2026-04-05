package com.epw.academy.service;

import java.util.List;

import com.epw.academy.dto.CreateInstructorRequest;
import com.epw.academy.dto.InstructorResponse;

public interface InstructorService {

    InstructorResponse create(CreateInstructorRequest request);

    List<InstructorResponse> list();
}