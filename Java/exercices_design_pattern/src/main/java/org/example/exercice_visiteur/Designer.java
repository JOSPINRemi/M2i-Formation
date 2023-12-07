package org.example.exercice_visiteur;

public class Designer implements Employee {
    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
