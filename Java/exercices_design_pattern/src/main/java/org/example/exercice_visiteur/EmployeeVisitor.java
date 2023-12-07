package org.example.exercice_visiteur;

public interface EmployeeVisitor {
    void visit(Manager manager);
    void visit(Developer developer);
    void visit(Designer designer);
}
