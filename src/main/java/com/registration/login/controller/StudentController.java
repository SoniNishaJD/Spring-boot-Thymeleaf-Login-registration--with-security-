package com.registration.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.login.entity.Student;
import com.registration.login.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
    private StudentRepository repository;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(Student student) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
         
        repository.save(student);
         
        return "register_success";
    }

}
