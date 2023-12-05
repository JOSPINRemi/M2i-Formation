package org.example.demo_abstractfactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }
}
