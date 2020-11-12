package listeners;

import calc.CalcOperations;
import gui.MyJTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class  CalcButtonActionListener implements ActionListener {

        private MyJTextField jtxtNumber1;
        private MyJTextField jtxtNumber2;
        private MyJTextField jtxtResult;

    public CalcButtonActionListener(MyJTextField jtxtNumber1, MyJTextField jtxtNumber2, MyJTextField jtxtResult) {
        this.jtxtNumber1= jtxtNumber1;
        this.jtxtNumber2= jtxtNumber2;
        this.jtxtResult= jtxtResult;
    }

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (!(e.getSource() instanceof JButton)) {
//               return;
//            }
            JButton btn = (JButton) e.getSource();

            try {
                final double a = Double.parseDouble(jtxtNumber1.getText());
                final double b = Double.parseDouble(jtxtNumber2.getText());
                if (btn.getActionCommand().equals("+")) {
                    jtxtResult.setText(String.valueOf(CalcOperations.add(a,b)));
                } else if (btn.getActionCommand().equals("/")) {
                    jtxtResult.setText(String.valueOf(CalcOperations.divide(a,b)));
                }
                if (btn.getActionCommand().equals("-")) {
                    jtxtResult.setText(String.valueOf(CalcOperations.subtract(a,b)));
                }
                if (btn.getActionCommand().equals("*")) {
                    jtxtResult.setText(String.valueOf(CalcOperations.multiply(a,b)));
                }
            } catch (Exception exc) {
                jtxtResult.setText("Input only number!");
                return;
            }
        }
    }
