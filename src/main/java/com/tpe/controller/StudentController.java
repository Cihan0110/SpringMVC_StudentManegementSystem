package com.tpe.controller;

import com.tpe.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students") // http://localhost:8080/SpringMVC181/students // .com/students
public class StudentController {

    @GetMapping("/hi") //http://localhost:8080/SpringMVC181/students/hi // .com/students/hi
    public ModelAndView sayHi(){

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi there!");
        mav.addObject("messagebody", "This is a Student Management System.");
        mav.setViewName("hi");
        return mav;

    }

    @GetMapping("/new") //http://localhost:8080/SpringMVC181/students/new // .com/students/new
    public String sendStudentForm(@ModelAttribute("student")Student student){
        return "studentForm";
    }

}
