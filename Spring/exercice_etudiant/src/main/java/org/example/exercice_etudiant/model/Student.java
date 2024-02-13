package org.example.exercice_etudiant.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;
}
