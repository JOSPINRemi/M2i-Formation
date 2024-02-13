package org.example.exercice_etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.exercice_etudiant.model.Student;
import org.example.exercice_etudiant.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentRestController {
    private final StudentService studentService;

    @PostMapping("/add")
    public UUID submit(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return student.getId();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") UUID id) {
        return studentService.getStudentById(id);
    }
}
