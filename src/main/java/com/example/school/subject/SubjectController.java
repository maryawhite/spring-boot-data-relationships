package com.example.school.subject;

import com.example.school.student.Student;
import com.example.school.student.StudentController;
import com.example.school.student.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {
    //dependency injection
    private final SubjectRepository subjectRepository;
    public SubjectController(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/subjects")
    public String subjectIndex(Model model){
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subjects";
    }

    @GetMapping("/create/subject")
    public String viewAddNewTeacherForm(){
        return "createSubject";
    }

    @PostMapping("/create/subject")
    public String addNewStudent(@ModelAttribute Subject subject){
        subjectRepository.save(subject);
        return "redirect:/subjects";
    }

    @PutMapping("/subjects/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepository.getOne(subjectId);
        Student student = studentRepository.getOne(studentId);
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }


}
