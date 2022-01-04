package com.example.school.student;

import com.example.school.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany(mappedBy = "enrolledStudents") //the name enrolledStudents comes from the hashSet we created in Subject
    private Set<Subject> subjects = new HashSet<>();

    private String name;

    //default constructor
    public Student(){}

    //2 constructors, one with Id, one without
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }
}
