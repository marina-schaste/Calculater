package listeners;

import gui.Main;
import gui.MyJTextField;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.annotation.Annotation;

public class CalcTextFieldFocusListener implements FocusListener {

    private MyJTextField field;

    public CalcTextFieldFocusListener(MyJTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().trim().equals(Main.INPUT_NUMBER)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().trim().equals("")) {
            field.setText(Main.INPUT_NUMBER);
            field.setForeground(Color.GRAY);
        }
    }
}