package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students") // http://localhost:8080/SpringMVC181/students // .com/students
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hi") //http://localhost:8080/SpringMVC181/students/hi // .com/students/hi
    public ModelAndView sayHi(){

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi there!");
        mav.addObject("messagebody", "This is a Student Management System.");
        mav.setViewName("hi");
        return mav;

    }

    //get the new Student Form
    @GetMapping("/new") //http://localhost:8080/SpringMVC181/students/new // .com/students/new
    public String sendStudentForm(@ModelAttribute("student")Student student){
        return "studentForm";
    }

    //save the student
    @PostMapping("/saveStudent")
    public String createStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);

        return "redirect:/students";  //redirecting user to the /students page after we save student.
    }

    //get the all student
    @GetMapping
    public ModelAndView listAllStudents(){

        List<Student> students =  studentService.getAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",students);
        mav.setViewName("students");

        return mav;
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model){   //.com/students/update?name=jace etc etc

        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);

        return "studentForm";

    }

    @GetMapping("/delete/{id}")
    public String deleteStudents(@PathVariable("id") Long id){

        studentService.deleteStudent(id);

        return "redirect:/students";

    }



}
