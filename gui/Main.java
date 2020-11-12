package gui;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import listeners.CalcButtonActionListener;
import listeners.CalcTextFieldFocusListener;
import listeners.ChangeSkinActionListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final String INPUT_NUMBER= "Input number";

    private MyJButton btnAdd;
    private MyJButton btnSubtract;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;
    private MyJButton btnChangeSkin;
    private MyJButton btnDefaultSkin;

    private JLabel labelNumber1;
    private JLabel labelNumber2;
    private JLabel labelResult;

    private MyJTextField jtxtNumber1;
    private MyJTextField jtxtNumber2;
    private MyJTextField jtxtResult;

    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel panel3;

    private MyJFrame frame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        Main main = new Main();

        main.createLabels();
        main.createTextFields();
        main.createButtons();
        main.createPanels();
        main.createFrame();

    }

    private void createFrame() {
        frame = new MyJFrame("Calculater", 450, 200, new BorderLayout(2,2));
        frame.setMaximumSize(new Dimension(450,200));
        frame.setResizable(false);

        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.getContentPane().add(panel3, BorderLayout.SOUTH);
        addChangeSkinListeners();
        frame.setVisible(true);
    }

    private void createPanels() {
        panel1 = new MyJPanel("panel1",100,100);
        panel1.setPreferredSize(new Dimension(200,50));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new MyJPanel("panel2",100,100);
        panel2.setPreferredSize(new Dimension(200,50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new MyJPanel("panel3",100,100);
        panel3.setPreferredSize(new Dimension(200,50));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1.add(labelNumber1);
        panel1.add(jtxtNumber1);
        panel1.add(labelNumber2);
        panel1.add(jtxtNumber2);

        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);

        panel3.add(labelResult);
        panel3.add(jtxtResult);
        panel3.add(btnChangeSkin);
        panel3.add(btnDefaultSkin);
    }

    private void createButtons() {
        btnAdd = new MyJButton("+");
        btnSubtract = new MyJButton("-");
        btnDivide = new MyJButton("*");
        btnMultiply = new MyJButton("/");
        btnChangeSkin = new MyJButton("Themes1");
        btnDefaultSkin = new MyJButton("Themes2");

        addButtonListener();
    }

    private void createTextFields() {
        jtxtNumber1 = new MyJTextField(INPUT_NUMBER,10);
        jtxtNumber2 = new MyJTextField(INPUT_NUMBER,10);

        jtxtResult = new MyJTextField(15, Color.BLACK);
        jtxtResult.setEditable(false);
        jtxtResult.setFocusable(false);

        addTextFieldListener();
    }

    private void createLabels() {
        labelNumber1 = new JLabel("number_1");
        labelNumber2 = new JLabel("number_2");
        labelResult = new JLabel("Result");
    }

    private void addButtonListener(){
        CalcButtonActionListener bl = new CalcButtonActionListener(jtxtNumber1, jtxtNumber2, jtxtResult);

        btnAdd.addActionListener(bl);
        btnSubtract.addActionListener(bl);
        btnMultiply.addActionListener(bl);
        btnDivide.addActionListener(bl);
    }

    private void addTextFieldListener() {
        jtxtNumber1.addFocusListener(new CalcTextFieldFocusListener(jtxtNumber1));
        jtxtNumber2.addFocusListener(new CalcTextFieldFocusListener(jtxtNumber2));
    }

    private void addChangeSkinListeners() {
        btnChangeSkin.addActionListener(new ChangeSkinActionListener(frame, new SmartLookAndFeel()));
        btnDefaultSkin.addActionListener(new ChangeSkinActionListener(frame, new BernsteinLookAndFeel()));
    }
}
