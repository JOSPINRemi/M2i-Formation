package org.example.exercice_visiteur;

public class Manager implements Employee {
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
