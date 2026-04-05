package com.epw.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.academy.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}