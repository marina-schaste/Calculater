package listeners;

import gui.MyJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;

public class ChangeSkinActionListener implements ActionListener {

    private LookAndFeel laf;
    private JFrame frame;

    public ChangeSkinActionListener(JFrame frame, LookAndFeel laf) {
        this.frame = frame;
        this.laf = laf;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChangeSkinActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(frame);

    }
}

