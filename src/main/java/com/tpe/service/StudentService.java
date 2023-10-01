package com.tpe.service;

import com.tpe.domain.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student getStudentById(Long id);

    List<Student> gelAllStudents();

    void deleteStudent(Long id);


}
