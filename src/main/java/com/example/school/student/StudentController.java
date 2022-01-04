package com.example.school.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    //dependency injection, create a Repository instance and initialize it in the controller class constructor
    private final StudentRepository studentRepository; //or you could name this studentDao
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String studentIndex(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/create/student")
    public String viewAddNewStudentForm(){
        return "createStu";
    }

    @PostMapping("/create/student")
    public String addNewStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }


}
