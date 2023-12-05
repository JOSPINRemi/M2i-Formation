package org.example.demo_abstractfactory;

public class MacFactory extends GUIFactory {
    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
