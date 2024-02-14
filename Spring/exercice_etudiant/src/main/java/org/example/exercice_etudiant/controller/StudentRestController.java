package org.example.exercice_etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.exercice_etudiant.model.Student;
import org.example.exercice_etudiant.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentRestController {
    private final StudentService studentService;

    @PostMapping("/add")
    public UUID submit(@RequestBody Student student) {
        return studentService.createStudent(student).getId();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") UUID id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam(name = "lastname", required = false) String lastName){
        return studentService.getStudentsByLastName(lastName);
    }
}
