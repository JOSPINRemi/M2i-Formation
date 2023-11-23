package org.example.poo.enums;

public enum MessageType {
    A,
    B,
    C,
    D;

    public Priority getPriority() {
        Priority priority = Priority.LOW;
        switch (this) {
            case A:
                priority = Priority.HIGH;
                break;
            case B:
                priority = Priority.MEDIUM;
                break;
        }
        return priority;
    }
}