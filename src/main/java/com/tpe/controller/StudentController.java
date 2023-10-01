package com.tpe.controller;

import com.tpe.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/hi")
    public ModelAndView sayHi(){

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi There !");
        mav.addObject("messagebody","This is a Student Management System.");
        mav.setViewName("hi");
        return mav;
    }

    @GetMapping("/new")
    public String sendStudentFrom(@ModelAttribute("student")Student student){

        return "studentForm";

    }

}