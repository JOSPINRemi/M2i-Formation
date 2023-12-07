package org.example.exercice_visiteur;

public class PerformanceEvaluator implements EmployeeVisitor {
    @Override
    public void visit(Manager manager) {
        System.out.println("PerformanceEvaluator visit Manager");
    }

    @Override
    public void visit(Developer developer) {
        System.out.println("PerformanceEvaluator visit Developer");
    }

    @Override
    public void visit(Designer designer) {
        System.out.println("PerformanceEvaluator visit Designer");
    }
}
