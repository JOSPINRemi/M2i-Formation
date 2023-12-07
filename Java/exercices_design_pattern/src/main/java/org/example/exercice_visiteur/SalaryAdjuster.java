package org.example.exercice_visiteur;

public class SalaryAdjuster implements EmployeeVisitor {
    @Override
    public void visit(Manager manager) {
        System.out.println("SalaryAdjuster visit Manager");
    }

    @Override
    public void visit(Developer developer) {
        System.out.println("SalaryAdjuster visit Developer");

    }

    @Override
    public void visit(Designer designer) {
        System.out.println("SalaryAdjuster visit Designer");
    }
}
