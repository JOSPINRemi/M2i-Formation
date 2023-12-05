package org.example.demo_abstractfactory;

public class WinFactory extends GUIFactory {
    @Override
    Button createButton() {
        return new WinButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}
