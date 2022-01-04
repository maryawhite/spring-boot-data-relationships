package com.example.school.teacher;

import com.example.school.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    //dependency injection, create a Repository instance and initialize it in the controller class constructor

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers")
    public String teacherIndex(Model model){
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers";
    }

    @GetMapping("/create/teacher")
    public String viewAddNewTeacherForm(){
        return "createTeacher";
    }

    @PostMapping("/create/teacher")
    public String addNewTeacher(@ModelAttribute Teacher teacher){
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

}
