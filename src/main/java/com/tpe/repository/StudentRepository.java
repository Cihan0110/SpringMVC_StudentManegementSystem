package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    void save(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();

    void delete (Long id);
}
