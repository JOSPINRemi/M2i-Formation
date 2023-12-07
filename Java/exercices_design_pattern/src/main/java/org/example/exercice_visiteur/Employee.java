package org.example.exercice_visiteur;

public interface Employee {
    void accept(EmployeeVisitor visitor);
}
