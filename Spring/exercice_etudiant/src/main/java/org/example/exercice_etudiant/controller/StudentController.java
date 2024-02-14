package org.example.exercice_etudiant.controller;

import lombok.RequiredArgsConstructor;
import org.example.exercice_etudiant.model.Student;
import org.example.exercice_etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("/add")
    public String  submit(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        model.addAttribute("search", false);
        return "student/students";
    }

    @GetMapping("/student/{studentId}")
    public String getStudent(@PathVariable("studentId") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/student";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam(name = "lastname", required = false) String lastName, Model model){
        List<Student> students = studentService.getStudentsByLastName(lastName);
        model.addAttribute("students", students);
        model.addAttribute("search", true);
        return "student/students";
    }
}
