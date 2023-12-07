package org.example.demo_visiteur;

public class Monitor implements PartElement {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
