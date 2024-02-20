package com.example.demo_h2_mapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private UUID id;
    private String blabla;
    private String lastName;
    private LocalDate birthDate;
    private Integer age;
}
