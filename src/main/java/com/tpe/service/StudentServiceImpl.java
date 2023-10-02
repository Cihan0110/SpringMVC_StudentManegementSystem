package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public void saveStudent(Student student) {

        repository.save(student);

    }

    @Override
    public Student getStudentById(Long id) {

        Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with ID: "+ id));

        return student;

    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {

        //repository.delete(id);

        Student student = getStudentById(id);
        repository.delete(student.getId()); // id

    }
}
