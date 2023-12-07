package org.example.demo_visiteur;

public interface Visitor {
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}
