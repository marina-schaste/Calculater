package gui;

import javafx.scene.text.Font;
import listeners.CalcTextFieldFocusListener;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class MyJTextField extends JTextField {

    public MyJTextField(String text, int columns) {
        this(columns);
        super.setText(text);
    }

    public MyJTextField(int columns) {
        super.setColumns(columns);
        Font font = new Font("Courier", 12);
//        super.setFont(font);
        super.setForeground(Color.BLACK);
    }

    public MyJTextField(int columns, Color textColor) {
        super.setColumns(columns);
        Font font = new Font("Courier",12);
//        super.setFont(font);
        super.setForeground(textColor);
    }

    public MyJTextField(String change_themes) {
    }

    public void addFocusListener(CalcTextFieldFocusListener calcTextFieldFocusListener) {
    }
}
