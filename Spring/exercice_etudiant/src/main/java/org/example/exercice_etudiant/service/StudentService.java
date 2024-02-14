package org.example.exercice_etudiant.service;

import org.example.exercice_etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    public Student createStudent(Student student) {
        student.setId(UUID.randomUUID());
        students.put(student.getId(), student);
        return student;
    }

    public List<Student> getStudents() {
        return students.values().stream().toList();
    }

    public Student getStudentById(UUID id) {
        return students.get(id);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return students.values()
                .stream()
                .filter(s -> s.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Student updateStudent(Student student) {
        return students.replace(student.getId(), student);
    }

    public void deleteStudent(UUID studentId) {
        students.remove(studentId);
    }
}
