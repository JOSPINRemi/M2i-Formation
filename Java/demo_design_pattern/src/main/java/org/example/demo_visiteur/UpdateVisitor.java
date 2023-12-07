package org.example.demo_visiteur;

public class UpdateVisitor implements Visitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("update keyboard element " + keyboard);
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("update monitor element " + monitor);
    }
}
